package com.ashwin.euler.problems;

public class Problem073 {

//	7295372
	public static void main(String[] args) {
		long millis = System.currentTimeMillis();
		double lower = 1.0 / 3.0, upper = 1.0 / 2.0;
		long count = 0;
		for(int i = 2; i <= 12000; i++) {
			for(int j = (int) Math.ceil(i * lower); j <= (int) Math.floor(i * upper); j++) {
				double fraction = (double) j / i;
				if(isRelativelyPrime(i, j) && fraction > lower && fraction < upper)
					count++;
			}
		}
		
		System.out.println(count);
		System.out.println(System.currentTimeMillis() - millis);
	}
	
//	Euclid's Algorithm for Greatest Common Denominator, if the GCD is
//	equal to 1, then the numbers are relatively prime. (not used)
	public static boolean isRelativelyPrime(long num1, long num2) {
		if(num1 == 0 || num2 == 0)
			return num1 == 1 || num2 == 1;
		
		if(num1 > num2)
			return isRelativelyPrime(num1 % num2, num2);
		else
			return isRelativelyPrime(num1, num2 % num1);
	}
}