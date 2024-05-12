package com.github.sats17.streams.examples;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class SortExamples {

	private static class Car implements Comparable<Car> {
		private String brand;
		private String details;

		public Car(String brand, String details) {
			this.brand = brand;
			this.details = details;
		}

		public String getBrand() {
			return brand;
		}

		public void setBrand(String brand) {
			this.brand = brand;
		}

		public String getDetails() {
			return details;
		}

		public void setDetails(String details) {
			this.details = details;
		}

		@Override
		public int compareTo(Car carToCompare) {
			if (this.brand.length() > carToCompare.brand.length()) {
				return 1;
			} else if (this.brand.length() < carToCompare.brand.length()) {
				return -1;
			} else {
				return 0;
			}
		}

		@Override
		public String toString() {
			return "Car [brand=" + brand + "]";
		}

	}

	public static void main(String[] args) {
		List<Car> cars = new ArrayList<>();

		// Real-world car brands and details
		String[] carBrands = { "Toyota", "Honda", "Ford", "Chevrolet", "Volkswagen", "Mercedes-Benz", "BMW", "Audi",
				"Hyundai", "Kia", "Volvo", "Lexus", "Subaru", "Mazda", "Nissan" };

		// Create Car objects with real brands and add them to the list
		for (int i = 0; i < carBrands.length; i++) {
			String brand = carBrands[i];
			String details = "Details for " + brand + " car";
			Car car = new Car(brand, details);
			cars.add(car);
		}

		// Print the list of Car objects
		for (Car car : cars) {
			System.out.println(car);
		}

		List<Car> sortedCars = cars.stream().sorted().collect(Collectors.toList());
		System.out.println("After sorted");
		for (Car car : sortedCars) {
			System.out.println(car);
		}

	}

}
