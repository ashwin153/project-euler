package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem074 {

	public static void main(String[] args) {
		long startTimeMillis = System.currentTimeMillis();
		int[] factorials = new int[10];
		factorials[0] = factorials[1] = 1;
		for (int i = 2; i < factorials.length; i++)
			factorials[i] = factorials[i - 1] * i;

		int[] lengths = new int[1000000];
		for (int i = 0; i < lengths.length; i++) {
			List<Integer> sequence = new ArrayList<Integer>();
			int currentValue = i;
			sequence.add(currentValue);
			int length = 1;
			
			while(!sequence.contains(currentValue = getFactorialDigitSum(currentValue, factorials))) {
				if(currentValue < lengths.length && lengths[currentValue] != 0) {
					length += lengths[currentValue];
					break;
				} else {
					sequence.add(currentValue);
					length++;
				}
			}
					
			lengths[i] = length;
		}
		
		int total = 0;
		for(int length : lengths)
			if(length == 60)
				total++;

		System.out.println(total);
		System.out.println(System.currentTimeMillis() - startTimeMillis);
	}
	
//	public static void main(String[] args) {
//		long startTimeMillis = System.currentTimeMillis();
//		int[] factorials = new int[10];
//		factorials[0] = factorials[1] = 1;
//		for(int i = 2; i < factorials.length; i++)
//			factorials[i] = factorials[i-1] * i;
//		
//		int total = 0;
//		for(int i = 0; i < 1000000; i++)
//			if(getNonRepeatingLength(i, factorials) == 60)
//				total++;
//		
//		System.out.println(total);
//		System.out.println(System.currentTimeMillis() - startTimeMillis);
//	}
	
	public static int getNonRepeatingLength(int num, int[] factorials) {
		List<Integer> numbers = new ArrayList<Integer>();
		numbers.add(num);
		int curNumber = num;
		
		while(!numbers.contains(curNumber = getFactorialDigitSum(curNumber, factorials)))
			numbers.add(curNumber);
		
		return numbers.size();
	}

	// Returns the sum of the factorials of each digit in a number
	public static int getFactorialDigitSum(int number, int[] factorials) {
		String str = String.valueOf(number);
		int sum = 0;
		
		for(char digit : str.toCharArray())
			sum += factorials[(int) digit - 48];
		
		return sum;
	}
}
