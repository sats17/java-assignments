package com.github.sats17.thread.advanced;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class Schedular implements Runnable {

	public static void main(String[] args) {
		ScheduledExecutorService scheduler = Executors.newScheduledThreadPool(5);
		ScheduledFuture<?> resp = scheduler.scheduleAtFixedRate(new Schedular(), 4, 4, TimeUnit.SECONDS);
//		while (resp.isDone() == true) {
//			System.out.println("Schedular completed his activity");
//			resp.notify();
//		}
	}

	@Override
	public void run() {
		System.out.println("Running scheduled job");
	}
	
}
