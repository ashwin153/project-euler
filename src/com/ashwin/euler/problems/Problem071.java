package com.ashwin.euler.problems;

import java.util.HashSet;
import java.util.Set;

public class Problem071 {

	// d < 8
	// n < d and n and d are relatively prime
	// number left of 3 / 7
	public static void main(String[] args) {
		double lower = 2.0 / 5.0, upper = 3.0 / 7.0, maxNumerator = 2.0;
		for(int i = 2; i <= 1000000; i++) {
			// Get totients of i (denominator) that are greater than lower and less than upper
			for(int j = (int) Math.ceil(i * lower); j < (int) Math.floor(i * upper); j++) {
				double fraction = (double) j / i;
				if(fraction > lower) {
					lower = fraction;
					maxNumerator = j;
				}
			}
		}
		
		System.out.println(maxNumerator);
	}
	
	public static long getTotient(long number) {
		Set<Long> primes = getPrimeFactors(number);
		double multiples = number;
		for(Long prime : primes)
			multiples *= (double) (prime - 1) / prime;
		return (long) multiples;
	}
	
	public static Set<Long> getPrimeFactors(long number) {
		Set<Long> primes = new HashSet<Long>();
		for(long i = 2; i <= number; i++) {
			if(number % i == 0L && isPrime(i)) {
				primes.add(i);
				number /= i;
			}
		}
		return primes;
	}
	
	public static boolean isPrime(long number) {
		for(long i = 2; i <= Math.sqrt(number); i++)
			if(number % i == 0L)
				return false;
		return true;
	}
}
