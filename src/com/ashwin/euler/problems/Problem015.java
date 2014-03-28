package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem015 {
	
	public static void main(String[] args) {
		System.out.println(path(20, 20).toString());
	}
	
	// distance! / (distance - 2)! 2! permutations
	public static BigInteger path(int numRows, int numCols) {
		int dist  = numRows + numCols;
		return factorial(dist).divide(factorial(numCols).multiply(factorial(numCols)));
	}
	
	public static BigInteger factorial(int num) {
		BigInteger factorial = new BigInteger("1");
		for(int i = 2; i <= num; i++)
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		return factorial;
	}
}
