package com.ashwin.euler.problems;

public class Problem014 {

	// n -> 3n + 1 if odd or n -> n/2 if even
	public static void main(String[] args) {
		int longestChain = 0;
		long number = -1;
		for(long i = 1; i <= 1000000L; i++) {
			int iter = getNumIterations(i);
			if(iter > longestChain) {
				longestChain = iter;
				number = i;
			}
		}
		
		System.out.println(number);
	}
	
	private static int getNumIterations(long num) {
		return getNumIterations(num, 1);
	}
	
	private static int getNumIterations(long num, int iter) {
		if(num == 1)
			return iter;
		
		if(num % 2 == 0L)
			return getNumIterations(num / 2, iter + 1);
		else
			return getNumIterations(3 * num + 1, iter + 1);
	}
}
