package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

/**
 * This problem asks for the first number that can be written as the sum of
 * primes in more than 5000 ways. The key to solving this problem was the
 * realization that I could recursively decompose numbers into a ordered
 * summation of primes. This helped me to avoid double counting sums.
 * 
 * @author ashwin
 * 
 */
public class Problem077 {

	public static void main(String[] args) {
		List<Long> primes = new ArrayList<Long>();
		long n = 1;
		
		do {
			if(isPrime(++n))
				primes.add(n);
		} while(ways(n, n - 2, primes) <= 5000);
		
		System.out.println(n);
	}
	
	public static long ways(long n, long max, List<Long> primes) {
		if(n < 0)
			return 0;
		else if(n == 0)
			return 1;
		
		int ways = 0;
		for(int i = 0; i < primes.size() && primes.get(i) <= max; i++)
			ways += ways(n - primes.get(i), primes.get(i), primes);
		return ways;
	}
	
	public static boolean isPrime(long n) {
		for(long x = 2; x <= Math.sqrt(n); x++)
			if(n % x == 0)
				return false;
		return true;
	}
}
