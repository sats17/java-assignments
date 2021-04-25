package com.github.sats17.subscriptions;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
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
	private List<Integer> storage;
	
	private List<Integer> storageProvider(){
		for(int i = 1; i <= 10; i++) {
			this.storage.add(i * 2);
		}
		return this.storage;
	}

	DataPublisher() {
		// Creates iterator via IntStream
		this.storage = new ArrayList<Integer>();
        this.iterator = storageProvider().iterator();
    }
	
	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		// Creating subscription between publisher and subscriber
		subscriber.onSubscribe(new DataSubscription(subscriber, this.iterator));
	}
	
}
