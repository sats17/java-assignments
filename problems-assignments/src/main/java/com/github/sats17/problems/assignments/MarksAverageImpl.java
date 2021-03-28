package com.github.sats17.problems.assignments;

import java.util.HashMap;

public class MarksAverageImpl {
	
	/*
	 * Multi Array is 
	 *	{{marks of sub1},{marks of sub2}}
	 */
	public static int[] findTotalSubAvgByEachStudent(int marks[][]) {
		int[] totalScore = new int[marks.length];
		for(int i = 0 ; i < marks.length ; i++) {
			int sum = 0;
			for(int j = 0;j < marks[i].length;j++) {
				sum = sum+marks[i][j];
			}
			totalScore[i] = sum / marks[i].length;
		}
		System.out.println(totalScore[0]);
		return totalScore;	
	}
	public static int[] findTotalAvgOfEachSubject(int marks[][]) {
		int[] totalSubAvg = new int[marks.length];
		for(int i = 0 ; i < marks.length ; i++) {
			int sum = 0;
			for(int j = 0;j < marks[i].length;j++) {
				sum = sum+marks[j][i];
			}
			totalSubAvg[i] = sum / marks[i].length;
		}
		System.out.println(totalSubAvg[0]);
		return totalSubAvg;	
	}
	
}
