package com.github.sats17.thread.advanced;

public class SharedCounter implements Runnable {

	// Volatile makes visibility of the variable as final. no caching will be involved.
	public volatile int counter;
	public final int iteration;
	
	public SharedCounter(int iteration) {
		this.iteration = iteration;
	}
	
	@Override
	public void run() {
		System.out.println(this.hashCode()+" "+Thread.currentThread().getId()+" Run invoked");
		
		for (int i = 0; i < this.iteration; i++) {
			increamenter(this.iteration);
		}
	}

	// synchronized makes logic written in method should be accesible by on thread at a time. So atomicity can be achieved.
	public synchronized void increamenter(int count) {
		counter++;
	}

	public static void main(String[] args) {
		
		SharedCounter counter = new SharedCounter(200000);
		
		for(int i = 0; i < 50; i++) {
			Thread t = new Thread(counter);
			t.start();
		}
		System.out.println("Thread creation done");
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(counter.counter);
	}
}
