package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem070 {

	public static void main(String[] args) {
		// Impossible for primes to have permutation totients
		long upper = 10000000L;
		long bound = (long) Math.sqrt(upper);
		
		for(long p1 = getNextLowestPrime(bound); p1 > 1; p1 = getNextLowestPrime(p1)) {
			for(long p2 = getNextHighestPrime(bound); p1 * p2 < upper; p2 = getNextHighestPrime(p2)) {
				long totient = getTotient(p1 * p2);
				if(isPermutation(p1 * p2, totient)) {
					System.out.println(p1 * p2 + ", " + totient + ", " + (p1 * p2 / totient));
					return;
				}
			}
		}
	}
		
	public static boolean isPermutation(long n1, long n2) {
		String str1 = String.valueOf(n1);
		String str2 = String.valueOf(n2);
		if(str1.length() != str2.length()) return false;
		
		for(int i = 0; i < str1.length(); i++)
			str2 = str2.replaceFirst(String.valueOf(str1.charAt(i)), "");
		
		return str2.isEmpty();
	}
	
	public static long getNextLowestPrime(long start) {
		for(long i = start - 1; i >= 0; i--)
			if(isPrime(i))
				return i;
		return -1;
	}
	
	public static long getNextHighestPrime(long start) {
		long i = start + 1;
		while(i > 0 && !isPrime(i))
			i++;
		return i;
	}
	
	public static List<Long> getAllPrimes(long limit) {
		List<Long> primes = new ArrayList<Long>();
		for(long i = 2; i <= limit; i++)
			if(isPrime(i))
				primes.add(i);
		return primes;
	}
	
//	Euler totient method is defined as the number *= (prime - 1) / prime for each prime
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
