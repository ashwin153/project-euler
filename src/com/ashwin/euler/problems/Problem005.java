package com.ashwin.euler.problems;

// http://projecteuler.net/problem=5
public class Problem005 {

	public static void main(String[] args) {
		for(int i = 20; i < 1000000000; i++) {
			if(divisible(i)) {
				System.out.println(i);
				break;
			}
		}
	}
	
	private static boolean divisible(int num) {
		for(int i = 2; i <= 20; i++)
			if(num % i != 0)
				return false;
		return true;
	}
}
