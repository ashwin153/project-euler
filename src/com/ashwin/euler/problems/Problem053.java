package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem053 {
	
	public static void main(String[] args) {
		int count = 0;
		for(int n = 1; n <= 100; n++) {
			for(int r = 1; r <= n; r++) {
				BigInteger result = factorial(n).divide(factorial(r).multiply(factorial(n - r)));
				if(result.compareTo(BigInteger.valueOf(1000000)) > 0)
					count++;
			}
		}
		System.out.println(count);
	}

	public static BigInteger factorial(int num) {
		BigInteger result = BigInteger.valueOf(1);
		for(int i = 2; i <= num; i++)
			result = result.multiply(BigInteger.valueOf(i));
		return result;
	}
}
