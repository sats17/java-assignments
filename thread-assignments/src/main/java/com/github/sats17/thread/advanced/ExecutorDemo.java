package com.github.sats17.thread.advanced;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

/**
 * This is the example of {@link java.util.concurrent.Executor} interface in java.
 * @author Sats17
 *
 */
public class ExecutorDemo {

	public static void main(String[] args) {
		System.out.println("Thread tutorial started");
		System.out.println("Current running thread from main() method is "+Thread.currentThread().getName());
		Executor exec = Executors.newCachedThreadPool();
		exec.execute(() -> {
			System.out.println("Runnable run() method call by "+Thread.currentThread().getName()+" thread");
		});
	}
	
}
