package com.github.sats17.streams.examples;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Class contains all methods which used to practice stream examples
 */
public class StreamPractice {

	public static double averageOfPositiveNumbers(List<Integer> numbers) {
		return numbers.stream().filter(num -> num > 0).mapToDouble(n -> n).average().orElse(0);
	}
	
	public static int findMaximumValue(List<Integer> numbers) {
		return numbers.stream().sorted((a, b) -> {
			if(a > b) {
				return -1;
			} else if (a < b) {
				return 1;
			} else {
				return 0;
			}
		}).findFirst().orElse(0);
	}
	
	public static void flattenList(List<List<Integer>> listOfLists) {
		listOfLists.stream().flatMap(value -> {
			System.out.println(value);
			return value.stream();
		}).forEach(val -> {
			System.out.println(val);
		});
		System.out.println("A");
	}

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4);
		double average = averageOfPositiveNumbers(numbers);
		int maxNumber = findMaximumValue(numbers);
		System.out.println("Average of positive numbers: " + average);
		System.out.println("Maximum numbers: " + maxNumber);
		List<List<Integer>> listOfLists = Arrays.asList(
	            Arrays.asList(1, 2, 3),
	            Arrays.asList(4, 5),
	            Arrays.asList(6, 7, 8)
	        );
		flattenList(listOfLists);
	}

}
