package com.ashwin.euler.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem024 {
	
	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
		int[] result = new int[numbers.size()];
		
		// Code is zero based, so position - 1
		double position = 999999;
		for(int i = 0; i < result.length; i++) {
			double value = factorial(result.length - i) / (result.length - i);
			result[i] = numbers.remove((int)((position) / value));
			position %= value;
		}

		for(int number : result)
			System.out.print(number);
	}
	
	public static int factorial(int num) {
		int factorial = 1;
		for(int i = 2; i <= num; i++)
			factorial *= i;
		return factorial;
	}
}
