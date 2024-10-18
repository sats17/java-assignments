package com.github.sats17.problems.assignments.strivers;

import java.util.ArrayList;
import java.util.List;

public class BinarySubarray {

    public static int[] slice(int[] arr, int startIndex, int endIndex) {
        if (endIndex >= arr.length || startIndex < 0) {
            throw new UnsupportedOperationException("Thik se index dedo bhai");
        }
        int arrSize = (endIndex + 1) - startIndex;
        int[] newArr = new int[arrSize];

        int counter = 0;
        for (int i = startIndex; i <= endIndex; i++) {
            newArr[counter] = arr[i];
            counter++;
        }
        return newArr;
    }

    public static int find(int[] arr, int sum) {
        return calculateNum(arr, sum) - calculateNum(arr, sum - 1);
    }

    public static int calculateNum(int[] arr, int goal) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int count = 0;

        while(right < arr.length) {
            sum += arr[right];
            while(sum > goal) {
                sum -= arr[left];
                left++;
            }
            count += right - left + 1;
            right++;
        }
        System.out.println(count);
        return count;
    }


    public static void main(String[] args) {
        int[] a = {1, 0, 1, 0, 1, 1};
        int n = 2;

        System.out.println(find(a, n));

    }

}
