package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem020 {

	public static void main(String[] args) {
		System.out.println(56 * 65);
		BigInteger factorial = new BigInteger("1");
		for(int i = 2; i <= 100; i++)
			factorial = factorial.multiply(new BigInteger(String.valueOf(i)));
		
		String str = factorial.toString();
		int digitSum = 0;
		for(int i = 0; i < str.length(); i++)
			digitSum += (int) str.charAt(i) - 48;
		System.out.println(digitSum);
	}
}
