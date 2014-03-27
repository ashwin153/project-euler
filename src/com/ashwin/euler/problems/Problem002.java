package com.ashwin.euler.problems;

// http://projecteuler.net/problem=2
public class Problem002 {

	public static void main(String[] args) {
		int x = 0, y = 1, z;
		
		int sum = 0;
		while(y < 4000000) {
			z = x + y;
			x = y;
			y = z;
			
			if(y % 2 == 0)
				sum += y;
		}
		
		System.out.println(sum);
	}
}
