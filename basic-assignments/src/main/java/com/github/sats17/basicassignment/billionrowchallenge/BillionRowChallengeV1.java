package com.github.sats17.basicassignment.billionrowchallenge;

import java.io.*;
import java.util.*;

// Use this command to generate measurement file from 1brc repo => java --class-path target/average-1.0.0-SNAPSHOT.jar dev.morling.onebrc.CreateMeasurements 1000000
// Use this command in VM to fetch jfr profile => -XX:StartFlightRecording=filename=C:\Users\satis\projects\java-assignments\basic-assignments\src\main\java\com\github\sats17\basicassignment\recording.jfr -XX:-Inline
public class BillionRowChallengeV1 {

    public void solve() {

        String filePath = "C:\\Users\\satis\\projects\\java-assignments\\basic-assignments\\src\\main\\java\\com\\github\\sats17\\basicassignment\\measurements.txt";

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            Map<String, List<Double>> storage = new HashMap<>();
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splittedLine = line.split(";");
                String city = splittedLine[0];
                String temp = splittedLine[1];
                Double convertedTemp = Double.valueOf(temp);
                storage.compute(city, (key, val) -> {
                    if(val == null) {
                        ArrayList<Double> list = new ArrayList<>();
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
                        var presentCount = val.get(3);

                        var newMax = Math.max(convertedTemp, presentMax);
                        var newMin = Math.min(convertedTemp, presentMin);
                        var newAvg = (presentSum + convertedTemp) / (presentCount + 1);
                        val.add(0, newMax);
                        val.add(1, newMin);
                        val.add(2, presentSum + convertedTemp);
                        val.add(3, newAvg);
                        val.add(4, presentCount + 1);
                        return val;
                    }
                });
            }

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
            System.out.println(sb);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        BillionRowChallengeV1 challenge = new BillionRowChallengeV1();
        long start = System.nanoTime();

        challenge.solve();

        long end = System.nanoTime();

        long durationNs = end - start;
        double durationMs = durationNs / 1_000_000.0;
        double durationSec = durationNs / 1_000_000_000.0;

        System.out.println("Time (ms): " + durationMs);
        System.out.println("Time (sec): " + durationSec);

    }

}
