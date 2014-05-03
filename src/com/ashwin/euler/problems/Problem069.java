package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem069 {

	private static final int LIMIT = 1000000;
	
//	Trying to maximize the numbers in the denominator
	public static void main(String[] args) {
		int prime = 1, value = 1;
		while((value * (prime = getNextPrime(prime))) < LIMIT)
			value *= prime;
		System.out.println(value);
	}
	
	public static int getNextPrime(int start) {
		int i = start + 1;
		while(i > 0 && !isPrime(i))
			i++;
		return i;
	}
	
//	Two numbers are relatively prime if they shareno common factors except for 1
//	public static void main(String[] args) {
//		long millis = System.currentTimeMillis();
//		List<Integer> primes = getAllPrimes((int) Math.sqrt(LIMIT));
//		
//		double[] maximum = new double[] {0, 0};
//		for(int i = 0; i < primes.size() - 1; i++) {
//			List<Integer> primeFactors = new ArrayList<Integer>();
//			primeFactors.add(primes.get(i));
//			
//			double[] nextSet = getMaximum(primes, primeFactors, primes.get(i), i + 1);
//			if(nextSet[1] > maximum[1])
//				maximum = nextSet;
//		}
//		
//		System.out.println((int) maximum[0]);
//	}
	
	public static double[] getMaximum(List<Integer> primes, List<Integer> primeFactors, int value, int counter) {
		double[] maximum = new double[] {value, getRatio(primeFactors, value)};
		for(int i = counter; i < primes.size(); i++) {
			int nextValue = value * primes.get(i);
			if(nextValue > LIMIT) break;
			
			List<Integer> nextFactors = new ArrayList<Integer>(primeFactors);
			nextFactors.add(primes.get(i));
			
			double[] nextSet = getMaximum(primes, nextFactors, nextValue, i + 1);
			maximum = (nextSet[1] > maximum[1]) ? nextSet : maximum;
		}
		
		return maximum;
	}
	
//	Euler totient method is defined as the number *= (prime - 1) / prime for each prime
	public static double getRatio(List<Integer> primes, int number) {
		double multiples = number;
		for(Integer prime : primes)
			multiples *= (double) (prime - 1) / prime;
		return number / multiples;
	}
	
//	Brute force method for finding the ratio (used for testing purposes)
	public static double getRatio(int number) {
		Set<Integer> primes = getPrimeFactors(number);
		double multiples = number;
		for(Integer prime : primes)
			multiples *= (double) (prime - 1) / prime;
		return number / multiples;
	}
	
//	Used by brute force method to fetch all UNIQUE prime factors
	public static Set<Integer> getPrimeFactors(int number) {
		Set<Integer> primes = new HashSet<Integer>();
		for(int i = 2; i <= number; i++) {
			if(number % i == 0 && isPrime(i)) {
				primes.add(i);
				number /= i;
			}
		}
		return primes;
	}
	
//	Euclid's Algorithm for Greatest Common Denominator, if the GCD is
//	equal to 1, then the numbers are relatively prime. (not used)
	public static boolean isRelativelyPrime(int num1, int num2) {
		if(num1 == 0 || num2 == 0)
			return num1 == 1 || num2 == 1;
		
		if(num1 > num2)
			return isRelativelyPrime(num1 % num2, num2);
		else
			return isRelativelyPrime(num1, num2 % num1);
	}
	
	public static List<Integer> getAllPrimes(int limit) {
		List<Integer> primes = new ArrayList<Integer>();
		for(int i = 2; i <= limit; i++)
			if(isPrime(i))
				primes.add(i);
		return primes;
	}
	
	public static boolean isPrime(int number) {
		for(int i = 2; i <= Math.sqrt(number); i++)
			if(number % i == 0)
				return false;
		return true;
	}
}
