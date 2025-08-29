package com.github.sats17.virtualthread;

// Java program to demonstrate exchange
// Data between threads using scoped values
import java.util.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//Driver class
public class VirtualThreadExample {
    // main function
    public static void main(String[] args) {
        try {
            // Initialization of thread
            Thread.Builder builder = Thread.ofVirtual().name("Custom thread");

            Runnable task = () -> {
                System.out.println("Running thread");
            };

            Thread t = builder.start(task);

            System.out.println("Thread t name: " + t.getName());

            // Add a delay to allow the virtual thread to run
            // Sleep for 1 second
            Thread.sleep(1000);
            System.out.println(t.isVirtual());
            t.join();

       } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}