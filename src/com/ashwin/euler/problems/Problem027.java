package com.ashwin.euler.problems;

public class Problem027 {

	public static void main(String[] args) {
		long maxPrimes = 0, maxProduct = 0;
		for(int a = -999; a < 1000; a++) {
			for(int b = -999; b < 1000; b++) {
				
				int n = 0;
				while(isPrime(n * n + a * n + b))
					n++;
								
				if(n > maxPrimes) {
					maxPrimes = n;
					maxProduct = a * b;
				}
			}
		}
		
		System.out.println(maxProduct);
	}
	
	public static boolean isPrime(int number) {
		for(int i = 2; i <= Math.sqrt(Math.abs(number)); i++)
			if(number % i == 0)
				return false;
		return true;
	}
}
