package com.github.sats17.thread.advanced;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;


public class CustomBlockingQueueTest {

    public static void main(String[] args) throws Exception {

//        shouldPutAndTakeSingleElement();
//        shouldMaintainFifoOrder();
//        takeFromEmptyQueueShouldReturnNull();
//        shouldReuseSpaceAfterTakingElement();
//        shouldHandleCircularWrapAround();
        producerShouldWaitWhenQueueIsFull();
//        multipleProducersShouldEventuallyInsertAllValues();
//        producerShouldNotLoseValueAfterWaiting();
//        multiplePutTakeCyclesShouldWork();

        System.out.println("ALL TESTS PASSED");
    }


    static void shouldPutAndTakeSingleElement() throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        queue.put(10);

        assert queue.take() == 10 :
                "Expected 10";
    }


    static void shouldMaintainFifoOrder() throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(3);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assert queue.take() == 1 :
                "Expected 1";

        assert queue.take() == 2 :
                "Expected 2";

        assert queue.take() == 3 :
                "Expected 3";
    }


    static void takeFromEmptyQueueShouldReturnNull() {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        assert queue.take() == null :
                "Expected null from empty queue";
    }


    static void shouldReuseSpaceAfterTakingElement()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);

        assert queue.take() == 1 :
                "Expected 1";

        queue.put(3);

        assert queue.take() == 2 :
                "Expected 2";

        assert queue.take() == 3 :
                "Expected 3";
    }


    static void shouldHandleCircularWrapAround()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(3);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assert queue.take() == 1 :
                "Expected 1";

        assert queue.take() == 2 :
                "Expected 2";

        queue.put(4);
        queue.put(5);

        assert queue.take() == 3 :
                "Expected 3";

        assert queue.take() == 4 :
                "Expected 4";

        assert queue.take() == 5 :
                "Expected 5";
    }


    static void producerShouldWaitWhenQueueIsFull() throws Exception {

        CustomBlockingQueue<Integer> queue = new CustomBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);

        CountDownLatch producerStarted = new CountDownLatch(1);

        CountDownLatch producerFinished = new CountDownLatch(1);

        Thread producer = new Thread(() -> {
            try {
                producerStarted.countDown();

                queue.putWait(3);

                producerFinished.countDown();

            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();
        System.out.println("Starting");

        // Make sure producer actually started.
        assert producerStarted.await(1, TimeUnit.SECONDS) :
                "Producer did not start";

        // Producer should still be blocked.
        assert !producerFinished.await(
                5,
                TimeUnit.SECONDS
        ) : "Producer should be waiting";

        System.out.println("taking");
        // Free one slot.
        assert queue.take() == 1 :
                "Expected 1";

        // Producer should now finish.
        assert producerFinished.await(
                1,
                TimeUnit.SECONDS
        ) : "Producer did not finish after queue was freed";

        assert queue.take() == 2 :
                "Expected 2";

        assert queue.take() == 3 :
                "Expected 3";

        producer.join();
    }


    static void multipleProducersShouldEventuallyInsertAllValues()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        CountDownLatch startLatch =
                new CountDownLatch(1);

        Thread producer1 = new Thread(() -> {
            try {
                startLatch.await();
                queue.putWait(1);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer2 = new Thread(() -> {
            try {
                startLatch.await();
                queue.putWait(2);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        Thread producer3 = new Thread(() -> {
            try {
                startLatch.await();
                queue.putWait(3);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        producer1.start();
        producer2.start();
        producer3.start();

        startLatch.countDown();

        Thread.sleep(200);

        Integer first = queue.take();
        Integer second = queue.take();

        assert first != null :
                "First value should not be null";

        assert second != null :
                "Second value should not be null";

        Thread.sleep(200);

        Integer third = queue.take();

        assert third != null :
                "Third value should not be null";

        producer1.join(1000);
        producer2.join(1000);
        producer3.join(1000);

        assert !producer1.isAlive() :
                "Producer 1 is still alive";

        assert !producer2.isAlive() :
                "Producer 2 is still alive";

        assert !producer3.isAlive() :
                "Producer 3 is still alive";
    }


    static void producerShouldNotLoseValueAfterWaiting()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(1);

        queue.put(100);

        Thread producer = new Thread(() -> {
            try {
                queue.putWait(200);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        producer.start();

        // Give producer time to enter wait().
        Thread.sleep(200);

        assert queue.take() == 100 :
                "Expected 100";

        producer.join(1000);

        assert !producer.isAlive() :
                "Producer is still waiting";

        assert queue.take() == 200 :
                "Expected 200";
    }


    static void multiplePutTakeCyclesShouldWork()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(3);

        for (int i = 1; i <= 100; i++) {

            queue.putWait(i);

            assert queue.take() == i :
                    "Expected " + i;
        }
    }
}
