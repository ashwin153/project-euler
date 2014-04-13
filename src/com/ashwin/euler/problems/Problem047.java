package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem047 {

	private static Map<Integer, Boolean> primes = new HashMap<Integer, Boolean>();

	// 134043
	public static void main(String[] args) {
		int counter = 1;		
		long startTimeMillis = System.currentTimeMillis();
		boolean c1 = false, c2 = false, c3 = false, c4 = false;
		
		while((c4 = getDistinctPrimeFactors(counter+3).size() != 4) ||
			  (c3 = getDistinctPrimeFactors(counter+2).size() != 4) ||
			  (c2 = getDistinctPrimeFactors(counter+1).size() != 4) ||
			  (c1 = getDistinctPrimeFactors(counter+0).size() != 4)) {
						
			if(c4)
				counter += 4;
			else if(c3)
				counter += 3;
			else if(c2)
				counter += 2;
			else
				counter++;
		}

		System.out.println(System.currentTimeMillis() - startTimeMillis);
		System.out.println(counter);
	}
	
	public static List<Integer> getDistinctPrimeFactors(int num) {
		List<Integer> factors = new ArrayList<Integer>();
		
		while(num > 1) {
			int largest = getSmallestPrimeFactor(num);
			if(!factors.contains(largest))
				factors.add(largest);
			num /= largest;
		}
		
		return factors;
	}
	
	public static boolean isPrime(int num) {
		if(primes.containsKey(num))
			return primes.get(num);
		
		primes.put(num, false);
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		
		primes.put(num, true);
		return true;
	}
	
	public static int getSmallestPrimeFactor(int num) {
		for(int i = 2; i <= num; i++)
			if(num % i == 0 && isPrime(i))
				return i;
		return 1;
	}
}
