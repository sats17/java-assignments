package com.github.sats17.thread.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class CustomThreadPool {

    List<Thread> threads;
    BlockingQueue<Runnable> tasks;
    private static final Runnable POISON = () -> {}; // Special task that wake all threads to close
    private volatile boolean shutDownAsked = false;

    public CustomThreadPool(int threads) {
        this.threads = new ArrayList<>(threads);
        int poolSize = 100;
        this.tasks = new ArrayBlockingQueue<>(poolSize);
        for(int i = 0; i < threads; i++) {
            Thread t = new Thread(() -> {
                while (true) {
                    try {
                        Runnable task = tasks.take();
                        if (task == POISON) {
                            break;
                        }
                        task.run();
                    } catch (InterruptedException e) {
                        break;
                    }

                }
            }, "custom-threadpool-"+i);
            t.start();
            this.threads.add(t);
        }
    }

    public void execute(Runnable runnable) {
        if(shutDownAsked) {
            throw new IllegalStateException("Cannot accept new tasks as shutdown being asked.");
        }
        tasks.add(runnable);
    }
    
    public void shutDown() {
        System.out.println("Shutdown asked, once all task completed threadpool will shutdown");
        if(shutDownAsked) {
            return;
        }
        shutDownAsked = true;
        for (int i = 0; i < threads.size(); i++) {
            tasks.add(POISON);
        }
    }

    static void main() throws InterruptedException {
        CustomThreadPool customThreadPool = new CustomThreadPool(12);
        Runnable work = () ->  {
            System.out.println("Work started on thread: "+Thread.currentThread().getName());
            long sum = 0;
            for (long i = 0; i < 5_000_000_000L; i++) {
                sum += i;
            }
            System.out.println(sum);
            System.out.println("Work completed on thread: "+Thread.currentThread().getName());
        };
        for(int i = 0; i < 13; i++) {
            if(i == 12) {
                customThreadPool.shutDown();
            }
            customThreadPool.execute(work);
            System.out.println("Submitted work from "+Thread.currentThread().getName());

        }
//        Thread.sleep(10);
//        customThreadPool.shutDown();
    }
}
