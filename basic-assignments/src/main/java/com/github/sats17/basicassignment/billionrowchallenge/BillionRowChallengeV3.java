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
 * V3 - Multi-Threaded Performance Optimization
 * Improvements over V2:
 * - Introduced ExecutorService with fixed thread pool (number of CPU cores)
 * - Replaced HashMap with ConcurrentHashMap for thread-safe concurrent access
 * - Implemented batch processing: reads lines in batches and submits tasks to thread pool
 * - Each batch is processed by separate threads to parallelize computation
 * - Uses proper shutdown and awaitTermination to ensure all threads complete before results
 * - Significant performance improvement through multi-core utilization
 */
public class BillionRowChallengeV3 {

    public void solve() {

        String filePath = "C:\\Users\\satis\\projects\\java-assignments\\basic-assignments\\src\\main\\java\\com\\github\\sats17\\basicassignment\\measurements_100million.txt";

        int cores = Runtime.getRuntime().availableProcessors();
        ExecutorService pool = Executors.newFixedThreadPool(cores);

        Map<String, List<Double>> storage = new ConcurrentHashMap<>();

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
            
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    void processBatch(List<String> lines, Map<String, List<Double>> storage) {
        for (String line : lines) {
            extractDataByCity(line, storage);
        }
    }

    private String formatTime(long nanos) {
        double ms = nanos / 1_000_000.0;
        if (ms < 1000) {
            return String.format("%.2f ms", ms);
        }
        double sec = nanos / 1_000_000_000.0;
        return String.format("%.2f sec", sec);
    }

    private static StringBuilder generateString(Map<String, List<Double>> storage) {
        Map<String, List<Double>> sortedMap = new TreeMap<>(storage);
        StringBuilder sb = new StringBuilder();
        sb.append("{");

        for(var entry : sortedMap.entrySet()) {
            var key = entry.getKey();
            List<Double> val = entry.getValue();
            sb.append(key)
                    .append("=")
                    .append(val.get(1))
                    .append("/")
                    .append(val.get(3))
                    .append("/")
                    .append(val.get(0))
                    .append(", ");
        }
        sb.setLength(sb.length() -2);
        sb.append("}");
        return sb;
    }

    private static void extractDataByCity(String line, Map<String, List<Double>> storage) {
        String[] splittedLine = line.split(";");
        String city = splittedLine[0];
        String temp = splittedLine[1];
        Double convertedTemp = Double.valueOf(temp);
        storage.compute(city, (key, val) -> {
            if(val == null) {
                LinkedList<Double> list = new LinkedList<>();
                list.add(convertedTemp); // max
                list.add(convertedTemp); // min
                list.add(convertedTemp); // sum
                list.add(convertedTemp); // avg
                list.add(1D); // count
                return list;
            } else {
                var presentMax = val.get(0);
                var presentMin = val.get(1);
                var presentSum = val.get(2);
                var presentCount = val.get(4);

                var newMax = Math.max(convertedTemp, presentMax);
                var newMin = Math.min(convertedTemp, presentMin);
                var newAvg = (presentSum + convertedTemp) / (presentCount + 1);
                val.set(0, newMax);
                val.set(1, newMin);
                val.set(2, presentSum + convertedTemp);
                val.set(3, newAvg);
                val.set(4, presentCount + 1);
                return val;
            }
        });
    }


    public static void main(String[] args) {
        BillionRowChallengeV3 challenge = new BillionRowChallengeV3();
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
