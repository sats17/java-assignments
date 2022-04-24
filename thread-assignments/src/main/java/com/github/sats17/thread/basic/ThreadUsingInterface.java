package com.github.sats17.thread.basic;

/**
 * In this example we are showing create a thread using Runnable interface. 
 * Basically in Thread class constructor we are passing implementation of Runnable interface.
 * @author Sats17
 *
 */
public class ThreadUsingInterface implements Runnable {

	@Override
	public void run() {
		System.out.println("run() method call by "+Thread.currentThread().getName()+" thread");
	}

	public static void main(String[] args) {
		System.out.println("Thread tutorial started");
		System.out.println("Current running thread from main() method is "+Thread.currentThread().getName());
		ThreadUsingInterface threadClass = new ThreadUsingInterface();
		threadClass.run();
		Thread thread = new Thread(threadClass);
		thread.start();
		
		// Another way of creating thread using lambda(Functional interface)
		Thread threadWithLambda = new Thread(() -> {
			System.out.println("Thread from lambda "+Thread.currentThread().getName());
		});
		threadWithLambda.start();
	}
	
	
}
