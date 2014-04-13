package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem050 {
	
	public static void main(String[] args) {
		System.out.println(getLongestPrime(1000000L));
	}
	
	public static long getLongestPrime(long limit) {
		List<Long> primes = new ArrayList<Long>();
		List<Long> sums   = new ArrayList<Long>();
		long currentSum = 2, lastPrime = 2;
		
		while(currentSum <= limit) {
			primes.add(lastPrime);
			sums.add(0, currentSum);
			lastPrime = getNextPrime(lastPrime);
			currentSum += lastPrime;
		}
		
		for(int i = 0; i < sums.size(); i++) {
			if(isPrime(sums.get(i)))
				return sums.get(i);
			
			for(int j = 0; j < i; j++) {
				if(isPrime(sums.get(j)))
					return sums.get(j);
				sums.set(j, sums.get(j) - primes.get(i - 1 - j));
			}
		}
				
		return -1;
	}
	
	public static long getNextPrime(long from) {
		long counter = from + 1;
		while(!isPrime(counter))
			counter++;
		return counter;
	}
	
	public static boolean isPrime(long num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
