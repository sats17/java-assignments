package com.github.sats17.streams.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
	
	public static void separateOddAndEvenNumbersFromList(List<Integer> listOfNumbers) {
		List<Integer> oddNumbers = new ArrayList<Integer>();
		List<Integer> evenNumbers = new ArrayList<Integer>();
		listOfNumbers.stream().forEach(val -> {
			if(val % 2 == 0) {
				evenNumbers.add(val);
			} else {
				oddNumbers.add(val);
			}
		});
		Map<Boolean, List<Integer>> partitionedNumbers = listOfNumbers.stream().collect(Collectors.partitioningBy(val -> val % 2 == 0));
		
		List<Integer> evenPNumbers = partitionedNumbers.get(true);
        List<Integer> oddPNumbers = partitionedNumbers.get(false);

        // Print the results
        System.out.println("Even numbers: " + evenPNumbers);
        System.out.println("Odd numbers: " + oddPNumbers);
		
		System.out.println(oddNumbers.toString());
		System.out.println(evenNumbers.toString());
	}
	
	public static void removeDuplicateElements(List<Integer> values) {
		System.out.println(values.stream().distinct().toList());
	}
	
	public static void findFrequencyOfEachCharInString(String values) {
		List<String> val = new ArrayList<>(Arrays.asList(values.split("")));
		HashMap<String, Integer> frequency = new HashMap<>();
		val.stream().forEach(value -> {
			frequency.compute(value, (k, v) -> v == null ? 1 : v + 1);
		});
		System.out.println(frequency.toString());
	}
	
	public static void reverseNumbers(List<Double> values) {
		values.stream().map(val -> {
			double reverse = 0;
			while(val > 0) {
				Double t = val % 10;
				reverse  = t * 10 + reverse;
				val = val / 10;
			}
			return reverse;
		}).forEach(val -> System.out.println(val));
	}
	
	public static void joinListOfString(List<String> values) {
		System.out.println(values.stream().collect(Collectors.joining(",", "[", "]")));
	}
	
	public static void printNumberOfFromListMultipleOf(List<Integer> values, Integer value) {
		values.stream().filter(val -> val % value == 0).forEach(System.out::println);
	}
	
	public static void findMaxAndMin(List<Integer> values) {
		Comparator<Integer> comparator = (a, b) -> a.compareTo(b);
		System.out.println(values.stream().min(comparator).get().intValue());
		System.out.println(values.stream().max(comparator).get().intValue());
	}
	
	public static void mergeTwoUnsortedArrayIntoSorted(List<Integer> values1, List<Integer> values2) {
		System.out.println(Stream.concat(values1.stream(), values2.stream()).sorted().collect(Collectors.toList()));
		System.out.println(Stream.concat(values1.stream(), values2.stream()).distinct().sorted().collect(Collectors.toList()));
	}
	
	public static void getThreeMaxAndMin(List<Integer> values) {
		System.out.println(values.stream().sorted().distinct().limit(3).toList());
		System.out.println(values.stream().sorted((a, b) -> b.compareTo(a)).distinct().limit(3).toList());

	}
	

	public static void main(String[] args) {
		List<Integer> numbers = List.of(1, 2, 3, 4, 5, 6, 7, 8, 8, 1, 2);
		List<Integer> numbers2 = List.of(11, 212, 3, 0, 15, 46, 7, 8, 8, 1, 2);
//		double average = averageOfPositiveNumbers(numbers);
//		int maxNumber = findMaximumValue(numbers);
//		System.out.println("Average of positive numbers: " + average);
//		System.out.println("Maximum numbers: " + maxNumber);
//		List<List<Integer>> listOfLists = Arrays.asList(
//	            Arrays.asList(1, 2, 3),
//	            Arrays.asList(4, 5),
//	            Arrays.asList(6, 7, 8)
//	        );
//		flattenList(listOfLists);
//		separateOddAndEvenNumbersFromList(numbers);
//		removeDuplicateElements(numbers);
//		findFrequencyOfEachCharInString("ssccacfqt");
//		ArrayList<Double> val = new ArrayList<Double>();
//		val.add(123D);
//		val.add(4121D);
//		val.add(123.41D);
//		reverseNumbers(val);
//		joinListOfString(List.of("sat", "cas", "asf"));
//		printNumberOfFromListMultipleOf(numbers, 3);
//		findMaxAndMin(numbers);
//		mergeTwoUnsortedArrayIntoSorted(numbers, numbers2);
		getThreeMaxAndMin(numbers);
	}

}
