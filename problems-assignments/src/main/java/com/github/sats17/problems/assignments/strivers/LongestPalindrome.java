package com.github.sats17.problems.assignments.strivers;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class LongestPalindrome {
    // mbakbkc
    public List<String> calculateRecursion(List<String> palindromes, int index, int strLen, String str) {
        System.out.println(index);
        if(index - 1 < 0 || index + 1 >= strLen) {
            System.out.println("From recurstion stom confiton" + index);
            return palindromes;
        } else {
            int rightIndex = index - 1;
            int leftIndex = index  + 1;
            StringBuilder builder = new StringBuilder(str);
            String longestString = "";
            while(rightIndex >= 0 && leftIndex < strLen && str.charAt(rightIndex) == str.charAt(leftIndex)) {
                longestString = builder.substring(rightIndex, leftIndex + 1);
                rightIndex--;
                leftIndex++;
            }
            if(!longestString.isEmpty()) {

                palindromes.add(longestString);
            }
            calculateRecursion(palindromes, rightIndex, strLen, str);
            calculateRecursion(palindromes, leftIndex, strLen, str);
        }

        return palindromes;
    }

    public String longestPalindrome(String str) {

        int middleLen = str.length() / 2;
        List<String> palindromes = new ArrayList<>();
        palindromes = calculateRecursion(palindromes, middleLen, str.length(), str);

        System.out.println(palindromes);

        return palindromes.stream().collect(Collectors.maxBy(Comparator.comparingInt(String::length))).orElse("");
    }

    public static void main(String[] args) {
        String abc = "abaaba";
        // Failing for this string

        LongestPalindrome cls = new LongestPalindrome();

        System.out.println(cls.longestPalindrome(abc));


    }

}
