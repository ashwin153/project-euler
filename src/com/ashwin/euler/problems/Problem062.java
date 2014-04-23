package com.ashwin.euler.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem062 {
	
	public static void main(String[] args) {
		long startTimeMillis = System.currentTimeMillis();
		System.out.println(getPermutationCubes());
		System.out.println(System.currentTimeMillis() - startTimeMillis);
	}
	
	public static long getPermutationCubes() {
		Map<Map<Integer, Integer>, Integer> digitCount = new HashMap<Map<Integer, Integer>, Integer>();
		Map<Map<Integer, Integer>, Long> smallestCubes = new HashMap<Map<Integer, Integer>, Long>();
		
		Map<Integer, Integer> digits = null;
		long counter = 1;
		while(!digitCount.containsValue(5)) {
			long cube = counter * counter * counter;
			digits = getDigits(cube);
			if(digitCount.containsKey(digits))
				digitCount.put(digits, digitCount.get(digits) + 1);
			else {
				digitCount.put(digits, 1);
				smallestCubes.put(digits, cube);
			}
			counter++;
		}
		
		return smallestCubes.get(digits);
	}
	
	public static Map<Integer, Integer> getDigits(long number) {
		String str = String.valueOf(number);
		Map<Integer, Integer> digits = new HashMap<Integer, Integer>();
		for(char letter : str.toCharArray()) {
			int value = Integer.valueOf(letter);
			if(digits.containsKey(value))
				digits.put(value, digits.get(value) + 1);
			else
				digits.put(value, 1);
		}
		return digits;
	}
}