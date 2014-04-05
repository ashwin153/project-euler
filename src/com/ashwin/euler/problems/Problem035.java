package com.ashwin.euler.problems;


public class Problem035 {

	public static void main(String[] args) {
		int count = 0;
		
		for(int i = 2; i <= 1000000; i++) {
			String str = String.valueOf(i);
			
			boolean isCircularPrime = true;
			for(int offset = 0; offset < str.length(); offset++) {
				String number = str.substring(offset) + str.substring(0, offset);
				if(!isPrime(Integer.valueOf(number))) {
						isCircularPrime = false;
						break;
				}
			}
			
			if(isCircularPrime)
				count++;
		}
		
		System.out.println(count);
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
