package com.ashwin.euler.problems;

// http://projecteuler.net/problem=3
public class Problem003 {

	public static void main(String[] args) {
		long number = 600851475143L;
		long largestPrime = -1;
		
		for(long i = 2; i <= number; i++) {
			if(number % i == 0L) {
				boolean isPrime = true;
				for(long j = 2; j < i; j++) {
					if(i % j == 0L) {
						isPrime = false;
						break;
					}
				}
				
				if(isPrime) {
					largestPrime = i;
					number /= i;
				}
			}
		}
		
		System.out.println(largestPrime);
	}
}
