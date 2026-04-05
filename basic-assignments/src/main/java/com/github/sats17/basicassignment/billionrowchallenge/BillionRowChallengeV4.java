package com.github.sats17.basicassignment.billionrowchallenge;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

// To generate a measurement data file, use this command => java --class-path target/average-1.0.0-SNAPSHOT.jar dev.morling.onebrc.CreateMeasurements 1000000
// Use this command in VM to fetch jfr profile => -XX:StartFlightRecording=filename=C:\Users\satis\projects\java-assignments\basic-assignments\src\main\java\com\github\sats17\basicassignment\recording.jfr -XX:-Inline

/**
 * - V4 - Data Class Refactor and used over linkedlist
 * Improvements over V3:
 * - Introduced a dedicated data class to encapsulate statistics (max, min, sum, avg, count) for better code readability and maintainability
 * - In V3 tiny overhead of get()/set() × 10M rows = big slowdown, so in V4 optimized data updates by modifying the existing object instead of creating new ones.
 *
 * - Used char array to split String instead of String.split() to reduce overhead of regex and multiple string creations.
 *
 * - Replaced Double with double to avoid unnecessary boxing and unboxing, which helped to reduce memory profiling.
 */

/**
 * JMC (JFR) ANALYSIS CHECKLIST – 1BRC
 *
 * 1. CPU HOTSPOTS
 *    - Open: Method Profiling / Hot Methods
 *    - Check: Top CPU-consuming methods
 *    - Goal: Identify slow parsing / hashing / logic
 *
 * 2. ALLOCATION PROFILE (MOST IMPORTANT)
 *    - Open: Memory → Allocation (TLAB / Outside TLAB)
 *    - Check: Most allocated classes
 *    - Red flags: String, char[], Integer, double
 *    - Goal: Reduce object creation
 *
 * 3. GC ANALYSIS
 *    - Open: Garbage Collections
 *    - Check: Pause time, frequency
 *    - Goal: Low pauses, mostly young GC, avoid old GC
 *
 * 4. OBJECT STATISTICS
 *    - Open: Object Statistics
 *    - Check: Top object types by count/size
 *    - Goal: Minimize heavy objects
 *
 * 5. ALLOCATION RATE
 *    - Open: Memory Overview
 *    - Check: MB/sec allocation rate
 *    - Goal: As low as possible
 *
 * 6. THREAD ANALYSIS
 *    - Open: Threads
 *    - Check: CPU vs idle time, lock contention
 *    - Goal: No blocking, fully CPU utilized
 *
 * 7. FILE I/O
 *    - Open: File I/O
 *    - Check: Read time, throughput
 *    - Goal: Efficient file reading (not bottleneck)
 *
 * 8. EXCEPTIONS
 *    - Open: Exceptions
 *    - Check: Exception count
 *    - Goal: Zero or minimal exceptions
 *
 * MENTAL MODEL:
 * CPU → ALLOCATION → GC → THREADS → I/O
 *
 * CORE RULE:
 * If allocation is high → performance will be slow.
 */
public class BillionRowChallengeV4 {

    // Create this record to modify later
    static class data {
        double max;
        double min;
        double sum;
        double avg;
        double count;

            public data(double max, double min, double sum, double avg, double count) {
                this.max = max;
                this.min = min;
                this.sum = sum;
                this.avg = avg;
                this.count = count;
            }

            public double getMax() {
                return max;
            }

            public double getMin() {
                return min;
            }

            public void update(double newTemp) {
                this.max = Math.max(this.max, newTemp);
                this.min = Math.min(this.min, newTemp);
                this.sum += newTemp;
                this.count += 1;
                this.avg = this.sum / this.count;
            }
    }

    public void solve() {

        String filePath = "C:\\Users\\satis\\projects\\java-assignments\\basic-assignments\\src\\main\\java\\com\\github\\sats17\\basicassignment\\measurements_10million.txt";

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);

        Map<String, data> storage = new ConcurrentHashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            // Timer for batch processing and submission
            long batchProcessingStart = System.nanoTime();
            
            List<String> batch = new ArrayList<>(cores);
            String line;

            while ((line = reader.readLine()) != null) {
                batch.add(line);

                if (batch.size() == cores) {
                    List<String> taskBatch = new ArrayList<>(batch);
                    pool.submit(() -> processBatch(taskBatch, storage));
                    batch.clear();
                }
            }
            if (!batch.isEmpty()) {
                List<String> taskBatch = new ArrayList<>(batch);
                pool.submit(() -> processBatch(taskBatch, storage));
            }

            long batchProcessingEnd = System.nanoTime();
            System.out.println("Batch processing and submission time: " + formatTime(batchProcessingEnd - batchProcessingStart));

            // Timer for thread pool completion
            long threadPoolStart = System.nanoTime();
            pool.shutdown();
            pool.awaitTermination(1, TimeUnit.HOURS);
            long threadPoolEnd = System.nanoTime();
            System.out.println("Thread pool execution time: " + formatTime(threadPoolEnd - threadPoolStart));

            // Timer for string generation
            long stringGenerationStart = System.nanoTime();
            StringBuilder sb = generateString(storage);
            long stringGenerationEnd = System.nanoTime();
            System.out.println("String generation time: " + formatTime(stringGenerationEnd - stringGenerationStart));
            
//            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void processBatch(List<String> lines, Map<String, data> storage) {
        for (String line : lines) {
            extractDataByCity(line, storage);
        }
    }

    private double formatTime(long nanos) {
        return nanos / 1_000_000.0;
    }

    private static StringBuilder generateString(Map<String, data> storage) {
        Map<String, data> sortedMap = new TreeMap<>(storage);
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for(var entry : sortedMap.entrySet()) {
            var key = entry.getKey();
            data val = entry.getValue();
            sb.append(key)
                    .append("=")
                    .append(val.min)
                    .append("/")
                    .append(val.avg)
                    .append("/")
                    .append(val.max)
                    .append(", ");
        }
        sb.setLength(sb.length() -2);
        sb.append("}");
        return sb;
    }

    private static void extractDataByCity(String line, Map<String, data> storage) {
        char[] lineCharArray = line.toCharArray();
        for(int i = 0; i < lineCharArray.length; i++) {
            if(lineCharArray[i] == ';') {
                char[] temparr = Arrays.copyOfRange(lineCharArray, i + 1, lineCharArray.length);
                double convertedTemp = Double.parseDouble(new String(temparr));
                storage.compute(new String(lineCharArray, 0, i), (key, val) -> {
                    if(val == null) {
                        return new data(convertedTemp, convertedTemp, convertedTemp, convertedTemp, 1d);
                    } else {
                        val.update(convertedTemp);
                        return val;
                    }
                });
                break;
            }
        }

    }


    public static void main(String[] args) {
        BillionRowChallengeV4 challenge = new BillionRowChallengeV4();
        long start = System.nanoTime();

        challenge.solve();

        long end = System.nanoTime();

        long durationNs = end - start;
        double durationMs = durationNs / 1_000_000.0;
        double durationSec = durationNs / 1_000_000_000.0;

        System.out.println("\n========== TOTAL EXECUTION TIME ==========");
        System.out.println("Time (ms): " + durationMs);
        System.out.println("Time (sec): " + durationSec);
        System.out.println("==========================================");
    }

}
