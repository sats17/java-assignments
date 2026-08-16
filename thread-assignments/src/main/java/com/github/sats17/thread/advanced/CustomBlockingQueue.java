package com.github.sats17.thread.advanced;

import java.util.LinkedList;

public class CustomBlockingQueue<E> {

    Object[] arr;
    private int putIndex = 0;
    private int takeIndex = 0;

    private Thread waitingThread;

    // Implement this with circular array with putIndex and takeIndex
    CustomBlockingQueue(int size) {
        arr = new Object[size];
    }

    public void put(E data) {
        int newPutIndex = putIndex + 1;
        if(newPutIndex > arr.length) {
            if(arr[0] == null) {
                putIndex = 0;
                arr[putIndex] = data;
            } else {
                System.out.println("Queue is full");
            }
        } else {
            arr[putIndex] = data;
            putIndex = newPutIndex;
        }
    }

    public synchronized void putWait(E data) throws Exception {
        int newPutIndex = putIndex + 1;
        if(newPutIndex > arr.length) {
            if(arr[0] == null) {
                putIndex = 0;
                arr[putIndex] = data;
            } else {
                System.out.println("Queue is full, waiting");
                waitingThread = Thread.currentThread();
                Thread.currentThread().wait();
                System.out.println("Wait complete");
                waitingThread = null;
                putWait(data);
            }
        } else {
            arr[putIndex] = data;
            putIndex = newPutIndex;
        }
    }

    public E take() {
        E data = (E) arr[takeIndex];
        if(data == null) {
            System.out.println("Nothing to pull");
            return null;
        } else {
            arr[takeIndex] = null;
        }
        if((takeIndex + 1) >= arr.length) {
            takeIndex = 0;
        } else {
            takeIndex = takeIndex + 1;
        }

        if(waitingThread != null) {
            waitingThread.notify();
        }
        return data;
    }

    public E takeWait() throws Exception {
        E data = (E) arr[takeIndex];
        if(data == null) {
            System.out.println("Nothing to pull");
            return null;
        } else {
            arr[takeIndex] = null;
        }
        if((takeIndex + 1) >= arr.length) {
            takeIndex = 0;
        } else {
            takeIndex = takeIndex + 1;
        }

        return data;
    }


    public void printQueue() {
        StringBuilder output = new StringBuilder();
        output.append("[");
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == null) {
                output.append("-");
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
        Thread a = new Thread(() -> {
            try {
                queue.putWait(3);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });
        a.start();
        // Fix this
        Thread.sleep(1000);
        queue.take();
        Thread.sleep(1000);
        queue.printQueue();
    }


    // [0,0,0,0]
    // insert 1 -> pI = 0 + 1, tI = 0
    // insert 2 -> pI = 1 + 1, tI = 0
    // pop -> pI = pI, tI = tI + 1
    // insert -> pI = pI + 1, tI = tI
    // insert -> pI = 0(if new pI > arrSize then go to 0)




}
