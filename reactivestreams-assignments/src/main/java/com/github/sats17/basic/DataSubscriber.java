package com.github.sats17.basic;

import java.util.concurrent.Flow.Subscriber;
import java.util.concurrent.Flow.Subscription;

/**
 * Basic subscriber example, where he subscribe to DataPublisher and listens and print data that DataPublisher will
 * publish.
 * 
 * @author sats17
 *
 */
public class DataSubscriber {
	public static void main( String[] args ) {
        System.out.println( "Started Reactive Streams!" );
        
        // Creating object of publisher class and passing subscriber to publisher object
        new DataPublisher(10).subscribe(new Subscriber<Integer>() {

			@Override
			public void onSubscribe(Subscription subscription) {
				// Not part of this example
			}

			@Override
			public void onNext(Integer item) {
					//Print whatever data that DataPublisher publishes
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
