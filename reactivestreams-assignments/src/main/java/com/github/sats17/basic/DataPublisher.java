package com.github.sats17.basic;

import java.util.Iterator;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.stream.IntStream;

/**
 * Basic naive approach of reactive streams using publisher and consumer/subscriber.
 * This example here our publisher using iterator and passing one element to subscriber in onNext method 
 *
 */
public class DataPublisher implements Publisher<Integer> {
	
	private final Iterator<Integer> iterator;

	DataPublisher(int count) {
		// Creates iterator via IntStream
        this.iterator = IntStream.rangeClosed(1, count).iterator();
    }
	
	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		// Pushing element to subscriber via on next method
		this.iterator.forEachRemaining(a -> subscriber.onNext(a));
		subscriber.onComplete();
	}
	
}
