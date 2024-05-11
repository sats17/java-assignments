package com.github.sats17.thread.advanced;

public class StringManipulation extends Thread {

	public void run() {
		
	}
	
//	public void start() {
//		System.out.println("Started start method");
//		System.out.println(Thread.currentThread().getId());
//	}
	
	public static void main(String[] args) {
		StringManipulation manipulation = new StringManipulation();
		System.out.println("Started code on main thread");
		System.out.println(Thread.currentThread().getId());
		StringBuilder builder = new StringBuilder();
		Runnable appendA = () -> {
			for(int i = 0; i < 100; i++) {
				builder.append("a");
			};
		};
		Runnable appendB = () -> {
			for(int i = 0; i < 100; i++) {
				builder.append("b");
			};
		};
		Thread thread1 = new Thread(appendA);
		Thread thread2 = new Thread(appendB);
		thread1.start();
		thread2.start();
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(builder.length());
		
	}
	
}
