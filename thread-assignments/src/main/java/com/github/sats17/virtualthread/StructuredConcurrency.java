package com.github.sats17.virtualthread;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.StructuredTaskScope;

public class StructuredConcurrency {

    public static void main(String[] args) throws Exception {
        shutDownOnSuccessExample();
    }

    private static void shutDownOnSuccessExample() throws InterruptedException, ExecutionException {
        List<String> ids = List.of("id1", "id2", "id3");

        try (var scope = new StructuredTaskScope.ShutdownOnSuccess<>()) {
            List<StructuredTaskScope.Subtask<String>> futures = ids.stream()
                    .map(id -> scope.fork(() -> callExternalApi(id))).toList();

            scope.join();
            var data = scope.result();// Wait for a task which can complete first
            System.out.println(data);
        }
    }

    static String callExternalApi(String id) throws InterruptedException {
        if("id1".equals(id)){
            Thread.sleep(502);
        } else {
            Thread.sleep(510);
        }
        System.out.println("triggered "+id);
        return "Data for " + id + " from API";
    }
}