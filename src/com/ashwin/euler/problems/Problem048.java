package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem048 {
	
	public static void main(String[] args) {
		BigInteger sum = BigInteger.valueOf(0);
		for(int i = 1; i <= 1000; i++)
			sum = sum.add(bigPower(i));
		String str = sum.toString();
		System.out.println(str.substring(str.length() - 10));
	}

	public static BigInteger bigPower(int n) {
		return BigInteger.valueOf(n).pow(n);
	}
}
