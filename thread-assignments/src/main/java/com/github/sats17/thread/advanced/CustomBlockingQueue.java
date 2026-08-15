package com.github.sats17.thread.advanced;

import java.util.LinkedList;

public class CustomBlockingQueue<E> {

    Object[] arr;
    private int putIndex = 0;
    private int takeIndex = 0;
    // Implement this with circular array with putIndex and takeIndex
    CustomBlockingQueue(int size) {
        arr = new Object[size];
    }

    public void put(E data) throws Exception {

        int newPutIndex = putIndex + 1;
        if(newPutIndex > arr.length) {
            if(arr[0] == null) {
                putIndex = 0;
                arr[putIndex] = data;
            } else {
                System.out.println("Queue is full");
                return;
            }
        } else {
            arr[putIndex] = data;
            putIndex = newPutIndex;
        }

    }

    public E take() throws Exception {
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

    static void main() {
        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(5);
        try {
            queue.put(1);
            queue.put(2);
            queue.put(3);
            queue.put(4);
            queue.put(5);
            queue.put(6);
            queue.take();
            queue.put(7);
            queue.printQueue();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    // [0,0,0,0]
    // insert 1 -> pI = 0 + 1, tI = 0
    // insert 2 -> pI = 1 + 1, tI = 0
    // pop -> pI = pI, tI = tI + 1
    // insert -> pI = pI + 1, tI = tI
    // insert -> pI = 0(if new pI > arrSize then go to 0)




}
