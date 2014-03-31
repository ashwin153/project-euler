package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem026 {
	
	public static void main(String[] args) {
		// Number will terminate only if its prime factorization is 2^a * 5^a
		int maxRepeats = 0, number = -1;
		for(int i = 1; i < 1000; i++) {
			if(!willTerminate(i)) {
				List<Integer> remainders = new ArrayList<Integer>();
				int repeats = numberOfRepeats(i, remainders);
				if(repeats > maxRepeats) {
					maxRepeats = repeats;
					number = i;
				}
			}
		}
		
		System.out.println(number);
	}
	
	public static int numberOfRepeats(int number, List<Integer> remainders) {
		int lastRemainder = (remainders.isEmpty()) ? 1 : remainders.get(remainders.size() - 1);
		int divisor = (int) Math.pow(10, Math.floor(Math.log10(number)) + 1) * lastRemainder;
		int remainder = divisor % number;
			
		if (remainders.contains(remainder))
			return remainders.size() - remainders.indexOf(remainder);
		else {
			remainders.add(remainder);
			return numberOfRepeats(number, remainders);
		}
	}
	
	public static boolean willTerminate(int number) {
		while(number > 1) {
			int prime = getSmallestPrimeFactor(number);
			number /= prime;
			
			if(prime != 2 && prime != 5)
				return false;
		}
		
		return true;
	}

	public static int getSmallestPrimeFactor(int number) {
		for(int i = 2; i < number; i++)
			if(number % i == 0 && isPrime(i))
				return i;
		return number;
	}
	
	public static boolean isPrime(int number) {
		for(int i = 2; i <= Math.sqrt(number); i++)
			if(number % i == 0)
				return false;
		return true;
	}
}
