package com.ashwin.euler.problems;

public class Problem007 {

	public static void main(String[] args) {
		int primeCount = 0, num = 2;
		
		while(primeCount < 10001) {
			if(isPrime(num))
				primeCount++;
			num++;
		}
		
		System.out.println(num - 1);
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
