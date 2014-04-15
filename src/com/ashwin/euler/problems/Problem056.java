package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem056 {

	public static void main(String[] args) {
		BigInteger limit = BigInteger.valueOf(100);
		int max = 0;
		for(BigInteger a = BigInteger.valueOf(2); a.compareTo(limit) < 0; a = a.add(BigInteger.ONE)) {
			for(int b = 2; b < limit.intValue(); b++) {
				int digitSum = digitSum(a.pow(b));
				if(digitSum > max)
					max = digitSum;
			}
		}
					
		System.out.println(max);
	}
	
	public static int digitSum(BigInteger num) {
		String str = num.toString();
		int digitSum = 0;
		for(int i = 0; i < str.length(); i++)
			digitSum += (int) str.charAt(i) - 48;
		return digitSum;
	}
}
