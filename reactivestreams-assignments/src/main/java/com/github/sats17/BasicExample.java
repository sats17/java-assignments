package com.github.sats17;

import java.util.Iterator;
import java.util.concurrent.Flow.Publisher;
import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;
import java.util.stream.IntStream;

/**
 * Basic naive approach of reactive streams using publisher and consumer/subscriber
 *
 */
public class BasicExample implements Publisher<Integer> {
	
	private final Iterator<Integer> iterator;

	BasicExample(int count) {
		// Creates iterator via IntStream
        this.iterator = IntStream.rangeClosed(1, count).iterator();
    }
	
	@Override
	public void subscribe(Subscriber<? super Integer> subscriber) {
		// Pushing element to subscriber via on next method
		this.iterator.forEachRemaining(a -> subscriber.onNext(a));
		subscriber.onComplete();
	}
	
    public static void main( String[] args ) {
        System.out.println( "Started Reactive Streams!" );
        // Creating object of publisher class and passing subscriber object
        new BasicExample(10).subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription subscription) {
				// Not part of this example
			}

			@Override
			public void onNext(Integer item) {
      				System.out.println("From on next method item received "+item);
			}

			@Override
			public void onError(Throwable throwable) {
				// Not part of this example
			}

			@Override
			public void onComplete() {
				System.out.println("On complete prints");
			}
		});
    }

	
}
