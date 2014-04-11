package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem043 {

	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		Collections.addAll(digits, new Integer[] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9});
		
		long sum = 0;		
		for(int pos = 0; pos < factorial(digits.size()); pos++) {				
			List<Integer> numbers = new ArrayList<Integer>(digits);
			StringBuilder sb = new StringBuilder();
			double position = pos;
			
			for(int i = 0; i < digits.size(); i++) {
				double value = factorial(digits.size() - i) / (digits.size() - i);
				sb.append(numbers.remove((int)((position) / value)));
				position %= value;
			}

			if(isSubstringDivisible(sb.toString()))
				sum += Long.valueOf(sb.toString());
		}
		
		System.out.println(sum);
	}
	
	public static int factorial(int num) {
		int factorial = 1;
		for(int i = 2; i <= num; i++)
			factorial *= i;
		return factorial;
	}
	
	public static boolean isSubstringDivisible(String number) {
		int currentPrime = 2;
		
		for(int i = 1; i <= number.length() - 3; i++)
			if(Integer.valueOf(number.substring(i, i + 3)) % currentPrime != 0)
				return false;
			else
				currentPrime = nextPrime(currentPrime);
		
		return true;
	}
	
	public static int nextPrime(int num) {
		int counter = num + 1;
		while(!isPrime(counter))
			counter++;
		return counter;
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
