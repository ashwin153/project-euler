package com.ashwin.euler.problems;

public class Problem046 {
	
	public static void main(String[] args) {
		boolean hasDiscovered = false;
		int counter = 5;
		while(!hasDiscovered) {
			counter += 2;
			if(!isPrime(counter))
				hasDiscovered = isSolution(counter);
		}
		System.out.println(counter);
	}
	
	public static boolean isSolution(int num) {
		for(int i = 2; i < num; i++)
			if(isPrime(i) && isPerfectSquare((num - i) / 2.0))
				return false;
		return true;
	}

	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
	
	public static boolean isPerfectSquare(double num) {
		double val = Math.sqrt(num);
		return val == (int) val;
	}
}
