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
            Thread t = new Thread(() ->{
               while(true) {
                   try {
                       Runnable task = tasks.take();
                       task.run();
                   } catch (InterruptedException e) {
                       throw new RuntimeException(e);
                   }
               }
            });
            t.start();
            threads.add(t);
        }
    }

    public void submit(Runnable runnable) throws InterruptedException {
        tasks.put(runnable);
    }

    static void main() throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(3);
        Runnable runnable = () ->  {
            System.out.println("Work started "+Thread.currentThread().getName());
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Work done "+Thread.currentThread().getName());
        };
        for(int i = 0; i < 10; i++) {
            customThreadPool.submit(runnable);
        }
    }



}
