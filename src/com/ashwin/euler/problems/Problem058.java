package com.ashwin.euler.problems;

public class Problem058 {

	public static void main(String[] args) {
		int numPrimes = 0, numTotal = 0, counter = 1, length = 1;
		while(numPrimes == 0 || numTotal == 0 || numPrimes / (double) numTotal > 0.10) {
			length += 2;
			
			for(int i = 0; i < 4; i++) {
				counter += length - 1;
				if(isPrime(counter))
					numPrimes++;
				numTotal++;
			}	
		}
		
		System.out.println(length);
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
