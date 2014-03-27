package com.ashwin.euler.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem012 {
	
	public static void main(String[] args) {
		long triangle = 1;
		long count = 2;
		
		while(count < 1000000) {
			if(getNumFactors(triangle) > 500) {
				System.out.println(triangle);
				return;
			}
			
			triangle += count;
			count++;
		}
	}
	
	public static int getNumFactors(long num) {
		Map<Long, Integer> set = new HashMap<Long, Integer>();
		
		while(!isPrime(num)) {
			long smallestFactor = smallestPrimeFactor(num);
			int curVal = set.get(smallestFactor) != null ? set.get(smallestFactor) : 0;
			set.put(smallestFactor, curVal + 1);
			
			num /= smallestFactor;
		}
		
		int curVal = set.get(num) != null ? set.get(num) : 0;
		set.put(num, curVal + 1);
		
		int numFactors = 1;
		for(Integer val : set.values())
			numFactors *= val + 1;
		return numFactors;
	}
	
	public static long smallestPrimeFactor(long num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0L && isPrime(i))
				return i;
		return num;
	}
	
	public static boolean isPrime(long num) {
		for(long i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0L)
				return false;
		return true;
	}
}
