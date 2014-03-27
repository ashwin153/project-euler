package com.ashwin.euler.problems;

public class Problem006 {

	public static void main(String[] args) {
		int squareSum = 0, sum = 0;
		for(int i = 1; i <= 100; i++) {
			squareSum += i * i;
			sum += i;
		}
		
		System.out.println(sum * sum - squareSum);
	}
}
