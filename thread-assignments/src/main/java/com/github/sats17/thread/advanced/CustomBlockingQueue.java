package com.github.sats17.thread.advanced;

import java.util.LinkedList;

public class CustomBlockingQueue<E> {

    Object[] arr;
    private int putIndex = 0;
    private int takeIndex = 0;


    CustomBlockingQueue(int size) {
        arr = new Object[size];
    }

    public void put(E data) {
        if(isQueueFull(putIndex)) {
            System.out.println("Queue is full");
            return;
        }
        arr[putIndex] = data;
        putIndex = nextIndex(putIndex);
    }

    public synchronized void putWait(E data) throws Exception {
        while(isQueueFull(putIndex)) {
            System.out.println("Queue is full, waiting");
            wait();
            System.out.println("Wait complete");
        }
        arr[putIndex] = data;
        putIndex = nextIndex(putIndex);
    }

    private boolean isQueueFull(int index) {
        return arr[index] != null;
    }

    private int nextIndex(int index) {
        return index + 1 >= arr.length ? 0 : index + 1;
    }

    public synchronized E take() {
        System.out.println("Taking value");
        E data = (E) arr[takeIndex];
        if(data == null) {
            System.out.println("Nothing to pull");
            return null;
        } else {
            arr[takeIndex] = null;
        }
        takeIndex = nextIndex(takeIndex);
        notify();
        return data;
    }

    public void printQueue() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                output.append("NULL");
            } else {
                output.append(arr[i]);
            }
            if(i != arr.length - 1) {
                output.append(",");
            }
        }
        output.append("]");
        System.out.println(output.toString());
    }

    static void main() throws InterruptedException {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(2);
        queue.put(1);
        queue.put(2);
        queue.put(3);
        queue.printQueue();
        Thread a = new Thread(() -> {
            try {
                queue.putWait(3);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        Thread b = new Thread(() -> {
            try {
                queue.putWait(4);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        b.start();
        System.out.println("From main thread");
        Thread.sleep(1000);
        queue.take();
        Thread.sleep(1000);
        queue.printQueue();
        System.out.println(queue.take());
        Thread.sleep(2000);
        queue.printQueue();

        // Fix why 4 insert before 3 (Because of JVM behaviour). Also fix why last printQueue prints (4, NULL)
        // instead of (3, 4)
    }


    // [0,0,0,0]
    // insert 1 -> pI = 0 + 1, tI = 0
    // insert 2 -> pI = 1 + 1, tI = 0
    // pop -> pI = pI, tI = tI + 1
    // insert -> pI = pI + 1, tI = tI
    // insert -> pI = 0(if new pI > arrSize then go to 0)




}