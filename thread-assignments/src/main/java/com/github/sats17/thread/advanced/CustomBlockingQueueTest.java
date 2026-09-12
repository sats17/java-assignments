package com.github.sats17.thread.advanced;

import org.junit.jupiter.api.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

import static org.junit.jupiter.api.Assertions.*;

class CustomBlockingQueueTest {

    @Test
    void shouldPutAndTakeSingleElement() throws Exception {
        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        queue.put(10);

        assertEquals(10, queue.take());
    }


    @Test
    void shouldMaintainFifoOrder() throws Exception {
        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(3);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertEquals(1, queue.take());
        assertEquals(2, queue.take());
        assertEquals(3, queue.take());
    }


    @Test
    void takeFromEmptyQueueShouldReturnNull() {
        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        assertNull(queue.take());
    }


    @Test
    void shouldReuseSpaceAfterTakingElement() {
        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        queue.put(1);
        queue.put(2);

        assertEquals(1, queue.take());

        queue.put(3);

        assertEquals(2, queue.take());
        assertEquals(3, queue.take());
    }


    @Test
    void shouldHandleCircularWrapAround() {
        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(3);

        queue.put(1);
        queue.put(2);
        queue.put(3);

        assertEquals(1, queue.take());
        assertEquals(2, queue.take());

        queue.put(4);
        queue.put(5);

        assertEquals(3, queue.take());
        assertEquals(4, queue.take());
        assertEquals(5, queue.take());
    }


    @Test
    void producerShouldWaitWhenQueueIsFull()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

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

        // Make sure producer actually started.
        assertTrue(
                producerStarted.await(1, TimeUnit.SECONDS)
        );

        // Producer should still be blocked because queue is full.
        assertFalse(
                producerFinished.await(200, TimeUnit.MILLISECONDS)
        );

        // Free one slot.
        assertEquals(1, queue.take());

        // Producer should now finish.
        assertTrue(
                producerFinished.await(1, TimeUnit.SECONDS)
        );

        assertEquals(2, queue.take());
        assertEquals(3, queue.take());

        producer.join();
    }


    @Test
    void multipleProducersShouldEventuallyInsertAllValues()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(2);

        CountDownLatch startLatch = new CountDownLatch(1);

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

        // Allow producers to start.
        Thread.sleep(200);

        // Keep consuming until all producers have inserted.
        Integer first = queue.take();
        Integer second = queue.take();

        assertNotNull(first);
        assertNotNull(second);

        // Give waiting producer an opportunity to insert.
        Thread.sleep(200);

        Integer third = queue.take();

        assertNotNull(third);

        producer1.join(1000);
        producer2.join(1000);
        producer3.join(1000);

        assertFalse(producer1.isAlive());
        assertFalse(producer2.isAlive());
        assertFalse(producer3.isAlive());
    }


    @Test
    void producerShouldNotLoseValueAfterWaiting()
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

        // Producer should be waiting.
        Thread.sleep(200);

        // Remove the existing item.
        assertEquals(100, queue.take());

        producer.join(1000);

        assertFalse(producer.isAlive());

        assertEquals(200, queue.take());
    }


    @Test
    void multiplePutTakeCyclesShouldWork()
            throws Exception {

        CustomBlockingQueue<Integer> queue =
                new CustomBlockingQueue<>(3);

        for (int i = 1; i <= 100; i++) {
            queue.putWait(i);

            assertEquals(i, queue.take());
        }
    }
}
