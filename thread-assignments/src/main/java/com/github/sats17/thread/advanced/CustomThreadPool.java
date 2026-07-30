package com.github.sats17.thread.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {

    private final int poolSize;
    List<Thread> threads;
    BlockingQueue<Runnable> tasks;


    public CustomThreadPool(int poolSize) {
        this.poolSize = poolSize;
        this.threads = new ArrayList<>(poolSize);
        this.tasks = new ArrayBlockingQueue<>(poolSize);
        for(int i = 0; i < poolSize; i++) {
            Thread t = new Thread(() -> {
                System.out.println("Thread started ");
                while (true) {
                    try {
                        Runnable task = tasks.take();
                        task.run();
                    } catch (InterruptedException e) {
                        break;
                    }
                }
            });
            System.out.println("Before start");
            t.start();
            threads.add(t);
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        tasks.put(runnable);
    }
    
    public void shutDown() {
        for (Thread t: threads) {
            System.out.println(t.getName());
            t.interrupt();
        }
    }

    static void main() throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(1);
        Runnable runnable = () ->  {
            System.out.println("Work started "+Thread.currentThread().getName());
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Work done "+Thread.currentThread().getName());
        };
        for(int i = 0; i < 1; i++) {
            customThreadPool.submit(runnable);
            System.out.println("Submitted "+Thread.currentThread().getName());
        }
        System.out.println("Completed");
        Thread.sleep(2000);
        customThreadPool.shutDown();
    }



}
