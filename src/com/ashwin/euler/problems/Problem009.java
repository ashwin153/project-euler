package com.ashwin.euler.problems;

public class Problem009 {

	public static void main(String[] args) {
		for(int a = 1; a < 1000; a ++) {
			for(int b = 1; b < 1000; b++) {
				int a2 = a * a;
				int b2 = b * b;
				
				if(isSquare(a2) && isSquare(b2) && isSquare(a2 + b2) &&
						a + b + Math.sqrt(a2 + b2) == 1000) {
					System.out.println(a * b * Math.sqrt(a2 + b2));
					System.out.println(a + ", " + b + ", " + Math.sqrt(a2 + b2));
					return;
				}
			}
		}
	}
	
	public static boolean isSquare(int num) {
		double sqrt = Math.sqrt(num);
		return sqrt == Double.valueOf((int) sqrt);
	}
}
