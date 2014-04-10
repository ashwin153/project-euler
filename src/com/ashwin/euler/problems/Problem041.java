package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem041 {
	
	public static void main(String[] args) {
		List<Integer> digits = new ArrayList<Integer>();
		Collections.addAll(digits, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
		int largest = -1;
		
		for(int n = digits.size(); n >= 1; n--) {
			// Total number of ways to mix and match them
			for(int pos = 0; pos < factorial(n); pos++) {				
				List<Integer> numbers = new ArrayList<Integer>(digits);
				StringBuilder sb = new StringBuilder();
				double position = pos;
				
				for(int i = 0; i < n; i++) {
					double value = factorial(n - i) / (n - i);
					sb.append(numbers.remove((int)((position) / value)));
					position %= value;
				}
				
				int result = Integer.valueOf(sb.toString());
				if(isPrime(result) && result > largest)
					largest = result;
			}
		}
		
		System.out.println(largest);
	}
	
	public static int factorial(int num) {
		int factorial = 1;
		for(int i = 2; i <= num; i++)
			factorial *= i;
		return factorial;
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
