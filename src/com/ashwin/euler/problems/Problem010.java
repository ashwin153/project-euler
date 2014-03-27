package com.ashwin.euler.problems;

public class Problem010 {
	
	public static void main(String[] args) {
		long sum = 0;
		for(long i = 2; i < 2000000L; i++)
			if(isPrime(i)) {
				sum += i;
				System.out.println(i);
			}
		System.out.println(sum);
	}

	public static boolean isPrime(long num) {
		for(long i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0L)
				return false;
		return true;
	}
}
