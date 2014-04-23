package com.ashwin.euler.problems;

public class Problem063 {
	
	public static void main(String[] args) {
		int n = 1, counter = 0;
		double bound = 0;
		
		while((bound = Math.pow(10, (n - 1.0) / n)) <= 9) {
			counter += 10 - Math.ceil(bound);
			n++;
		}
		
		System.out.println(counter);
	}
}
