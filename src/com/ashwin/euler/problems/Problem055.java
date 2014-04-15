package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem055 {

	public static void main(String[] args) {
		int counter = 0;
		for(int i = 1; i <= 10000; i++)
			if(isLychrel(BigInteger.valueOf(i)))
				counter++;
		System.out.println(counter);	
	}
	
	public static boolean isLychrel(BigInteger num) {
		BigInteger counter = num;
		for(int i = 0; i < 50; i++) {
			counter = counter.add(reverse(counter));
			if(isPalindromic(counter))
				return false;
		}
		return true;
	}
	
	public static boolean isPalindromic(BigInteger num) {
		String str = num.toString();
		for(int i = 0; i < str.length() / 2; i++)
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		return true;
	}
	
	public static BigInteger reverse(BigInteger num) {
		StringBuilder sb = new StringBuilder(String.valueOf(num));
		return new BigInteger(sb.reverse().toString());
	}
}
