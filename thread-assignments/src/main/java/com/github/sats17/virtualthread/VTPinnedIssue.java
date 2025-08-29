package com.github.sats17.virtualthread;
import java.util.ArrayList;
import java.util.List;

public class VTPinnedIssue {

    private static final Object LOCK = new Object();

    public static void main(String[] args) throws InterruptedException {
        System.out.println("jo");
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            Thread vt = Thread.startVirtualThread(() -> {
                synchronized (LOCK) {
                    try {
                        // -Djdk.tracePinnedThreads=full
                        System.out.println("sleep");
                        Thread.sleep(1000); // Simulate work
                    } catch (InterruptedException e) {
                        Thread.currentThread().interrupt();
                    }
                }
            });
            threads.add(vt);
        }

        // Wait for all virtual threads to finish
        for (Thread t : threads) {
            t.join();
        }

        System.out.println("All virtual threads finished.");
    }
}
