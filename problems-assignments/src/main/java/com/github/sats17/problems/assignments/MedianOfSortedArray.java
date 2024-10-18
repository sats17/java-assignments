package com.github.sats17.problems.assignments;

public class MedianOfSortedArray {

    public static void main(String[] args) {


        int[] a = {12, 244, 4125};
        int[] b = {1};

        int aLen = a.length;
        int bLen = b.length;

        int totalLen = aLen + bLen;

        int halfLen = totalLen / 2;

        int median1 = halfLen;
        int median2 = halfLen - 1;

        int medianValue1 = 0, medianValue2 = 0;
        int pointer1 = 0, pointer2 = 0;


        for (int i = 0; i <= halfLen; i++) {
            int chosenElement;
            if (pointer1 < aLen && (pointer2 >= bLen || a[pointer1] < b[pointer2])) {
                chosenElement = a[pointer1];
                pointer1++;
            } else {
                chosenElement = b[pointer2];
                pointer2++;
            }

            if (i == median1) {
                medianValue1 = chosenElement;
            }
            if (i == median2) {
                medianValue2 = chosenElement;
            }
        }

        if (totalLen % 2 == 0) {
            System.out.println((float) (medianValue1 + medianValue2) / 2);
        } else {
            System.out.println("For odd");
            System.out.println(medianValue1);
        }


    }
}
