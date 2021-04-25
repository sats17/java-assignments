package com.github.sats17.subscriptions;

import java.util.Iterator;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * Subscription class between publisher and subscriber, and class contains methods will provide data on demands
 * 
 * @author Sats17
 *
 */
public class DataSubscription implements Subscription {

	private final Subscriber<? super Integer> dataSubscriber;
	private Iterator<Integer> dataIterator;
	private AtomicBoolean isTerminated = new AtomicBoolean(false);

	public DataSubscription(Subscriber<? super Integer> subscriber, Iterator<Integer> iterator) {
		this.dataSubscriber = subscriber;
		this.dataIterator = iterator;
	}

	@Override
	public void request(long n) {
		// pre validations
		if (n <= 0) {
			dataSubscriber.onError(new IllegalArgumentException("Enter proper values for request"));
		}
		// Data will be pushed to subscriber here
		for (int demand = 0; demand < n && dataIterator.hasNext() && !isTerminated.get(); demand++) {
			dataSubscriber.onNext(dataIterator.next());
		}
		// If iterator has no data to provide then will notify subscriber with onComplete method
		if (!dataIterator.hasNext() && !isTerminated.getAndSet(true)) {
			dataSubscriber.onComplete();
		}
	}

	/**
	 * Once cancel method calls, no stream data will be pushed
	 */
	@Override
	public void cancel() {
		isTerminated.set(true);
	}

}
