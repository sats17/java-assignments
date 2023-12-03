package com.github.sats17.problems.assignments;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * This is tiny example of how Java Collections sorting or streams sorted works with comparator interface.
 * They have their own sorting algorithm and user just need to pass there sorting function. based on that sort works.
 */
public class MergeSort<T> {

	// Algorithm uses merge sort. It is divide and conquer algorithm.
	// Recursive method separate array till it's size 1. Once size 1 got, then it will collect the array
	// rejoin them by comparing each other element. Note point here is that, we know existing array is already sorted.
	// So we only compare each other array value from sortAndMergeList
	public List<T> mergeSort(List<T> inputArr, Comparator<T> fun) {
		if (inputArr.size() <= 1) {
			return inputArr;
		} else {
			int newArrSize = inputArr.size() / 2;
			List<T> firstList = inputArr.subList(0, newArrSize);
			List<T> secondList = inputArr.subList(newArrSize, inputArr.size());
			List<T> recursedFirstList = mergeSort(firstList, fun);
			List<T> recursedSecondList = mergeSort(secondList, fun);
			return sortAndMergeList(recursedFirstList, recursedSecondList, fun);
		}

	}

	public List<T> sortAndMergeList(List<T> list1, List<T> list2, Comparator<T> fun) {

		List<T> mergedList = new ArrayList<>();

		int list1Size = list1.size();
		int list2Size = list2.size();

		int list1Index = 0;
		int list2Index = 0;

		while (list1Index < list1Size && list2Index < list2Size) {
			int comparedResult = fun.compare(list1.get(list1Index), list2.get(list2Index));
			if (comparedResult == 1) {
				mergedList.add(list1.get(list1Index));
				list1Index++;
			} else {
				mergedList.add(list2.get(list2Index));
				list2Index++;
			}
		}

		while (list1Index < list1.size()) {
			mergedList.add(list1.get(list1Index));
			list1Index++;
		}

		while (list2Index < list2.size()) {
			mergedList.add(list2.get(list2Index));
			list2Index++;
		}

		return mergedList;
	}

	public static void main(String[] args) {
		List<String> arr = Arrays.asList("abc", "bcd", "ccd", "abcd", "a", "aaaaaaa");
		// Comparator function used here so we can pass custom sorting logic.
		Comparator<String> fun = (a, b) -> {
			if (a.length() < b.length())
				return 0;
			else
				return 1;
		};
		MergeSort<String> sortAlgo = new MergeSort<>();
		System.out.println(sortAlgo.mergeSort(arr, fun));
	}

}
