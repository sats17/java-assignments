package com.github.sats17.thread.basic;

/**
 * Sample program that shows how we can create thread using Extending thread class.
 * 
 * @author Sats17
 *
 */
public class ThreadUsingClass extends Thread {

	/**
	 * This method is contract method of Runnable interface and Thread class implements this method.
	 * When new Thread is created that new thread will run all code that present inside this thread.
	 */
	@Override
	public void run() {
		System.out.println("run() method call by "+Thread.currentThread().getName()+" thread");
	}
	
	public static void main(String[] args) {
		System.out.println("Thread tutorial started");
		System.out.println("Current running thread from main() method is "+Thread.currentThread().getName());
		ThreadUsingClass threadClass = new ThreadUsingClass();
		threadClass.run();
		threadClass.start();
	}
	
}
