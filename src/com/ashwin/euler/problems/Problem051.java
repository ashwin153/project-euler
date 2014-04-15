package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;


public class Problem051 {
	
	public static void main(String[] args) {		
		int numDigits = 3, counter = 100;
		// Note: This creates an infinite loop, however we know there is a
		// solution to the problem so this is semi-safe
		while(numDigits > 0) {
			List<String> combos = new ArrayList<String>();
			for(int i = 2; i <= numDigits; i++)
				getCombinations(combos, "", i, numDigits - i);
			
			while(String.valueOf(counter).length() <= numDigits) {
				if(isPrime(counter)) {
					for(String combo : combos) {
						int[] result = getPrimeCount(combo, counter);
						if(result[0] == 8) {
							System.out.println(result[1]);
							return;
						}
					}
				}
				counter++;
			}
			numDigits++;
		}
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
	
	public static int[] getPrimeCount(String combo, int number) {
		StringBuilder sb = new StringBuilder(String.valueOf(number));
		int count = 0, smallestPrime = Integer.MAX_VALUE;
		
		for(char digit = '1'; digit <= '9'; digit++) {
			for(int i = 0; i < combo.length(); i++) {
				if(combo.charAt(i) == '0')
					sb.setCharAt(i, digit);
			}
			
			int result = Integer.valueOf(sb.toString());
			if(isPrime(result)) {
				if(result < smallestPrime)
					smallestPrime = result;
				count++;
			}
		}
		
		return new int[] {count, smallestPrime};
	}
	
	public static void getCombinations(List<String> result, String combo, int c1, int c2) {
		if(c1 == 0 && c2 == 0)
			result.add(combo);
		
		if(c1 > 0) getCombinations(result, combo + "0", c1 - 1, c2);
		if(c2 > 0) getCombinations(result, combo + "1", c1, c2 - 1);
	}
}
