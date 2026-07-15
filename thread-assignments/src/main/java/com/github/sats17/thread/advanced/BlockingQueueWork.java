package com.github.sats17.thread.advanced;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

// Blocking helps in producer consumer pattern kind off, We don't need to poll every seconds to check whether queue is empty or not/
// Blocking queue notify us and thread wakes and start working.
public class BlockingQueueWork {

    static void main() {
        BlockingQueue<Integer> queue = new ArrayBlockingQueue<>(5);
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);
        Thread t = new Thread(() -> {
            try {
                queue.put(6); // This will block until space is available
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        t.start();
        try { // This will block until space is available
            queue.take(); // This will remove the head of the queue

            Thread.sleep(1000);
            System.out.println((long) queue.size());
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}
