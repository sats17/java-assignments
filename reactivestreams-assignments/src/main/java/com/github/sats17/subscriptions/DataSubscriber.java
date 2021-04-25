package com.github.sats17.subscriptions;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

/**
 * Basic subscriber example, where he subscribe to DataPublisher and creates subscription with publisher
 * and asks data on demand
 * 
 * @author sats17
 *
 */
public class DataSubscriber implements Subscriber<Integer>{
	
	Integer request;
	
	Subscription subscription;
	
	public DataSubscriber(Integer request) {
		this.request = request;
	}
	
	/**
	 * Subscribing to publisher and publisher will return data whatever we requested
	 */
	@Override
	public void onSubscribe(Subscription subscription) {
		this.subscription = subscription;
		System.out.println("Requesting first "+this.request+" elements to publisher");
		subscription.request(this.request); // Requesting number of first data that have to publisher will be given
	}

	@Override
	public void onNext(Integer item) {
		// Print whatever data that DataPublisher publishes
		System.out.println("Data receives from publisher " + item);
	}

	@Override
	public void onError(Throwable throwable) {
		// Any error occurs that will handle here
		System.out.println(throwable.getMessage());
	}

	@Override
	public void onComplete() {
		this.subscription.cancel();
		// If publisher is done with his data pushing that he have, then he will call this method
		System.out.println("We received all data from our publisher");
	}
	
	public static void main(String[] args) {
		System.out.println("Started Reactive Streams!\n");
		// Creating object of publisher class and passing subscriber to publisher object
		new DataPublisher().subscribe(new DataSubscriber(1));
		new DataPublisher().subscribe(new DataSubscriber(20));
	}

}
