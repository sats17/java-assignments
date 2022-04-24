package com.github.sats17.thread.advanced;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceDemo {

	public static void main(String[] args) {
		System.out.println("Thread tutorial started");
		System.out.println("Current running thread from main() method is " + Thread.currentThread().getName());
		List<Future<String>> futures = new ArrayList<>();
		ExecutorService execService = Executors.newCachedThreadPool();
		for (int i = 0; i < 10; i++) {
			try {
				Thread.sleep(200);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Future<String> future = execService.submit(() -> {
				System.out.println("Current running thread from call() method is " + Thread.currentThread().getName());
				return Thread.currentThread().getName();
			});
			futures.add(future);
		}
		futures.forEach((future) -> {
			try {
				System.out.println(future.get());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ExecutionException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		});

	}

}
