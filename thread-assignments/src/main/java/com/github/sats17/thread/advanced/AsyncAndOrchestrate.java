package com.github.sats17.thread.advanced;

/**
 * This class will show dummy example of how can we call two service and wait for each other to complete their response.
 * 
 * @author Sats17
 *
 */
public class AsyncAndOrchestrate {
	
	public static void usingRawThreadImplementation() {
		Thread backend1 = new Thread(() -> {
			System.out.println("Hello I am from backend 1, we have started calling to backend");
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello I am from backend 1, here is your response");
		});
		
		Thread backend2 = new Thread(() -> {
			System.out.println("Hello I am from backend 2, we have started calling to backend");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("Hello I am from backend 2, here is your response");
		});
		
		// started two different threads for backend1 and backend2. But cannot return anything as Run() method not allowed to do.
		backend1.start();
		backend2.start();
	}
	
	public static void main(String[] args) {
		System.out.println("Thread tutorial started");
		System.out.println("Current running thread from main() method is "+Thread.currentThread().getName());
		usingRawThreadImplementation();
	}

}
