package com.ashwin.euler.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;


public class Problem065 {

	public static void main(String[] args) {
		// 2, 3, 8/3, 11/4, 19/7, 87/32, 106/39, 193/71, 1264/465, 1457/536,
		// [2; 1,2,1, 1,4,1, 1,6,1 , ... , 1,2k,1, ...
		BigInteger[] result = getFraction(BigInteger.valueOf(2), 1, 100);		
		
		int digitSum = 0;
		for(char digit : result[1].toString().toCharArray())
			digitSum += (int) digit - 48;
		System.out.println(digitSum);
	}
	
	public static BigInteger[] getFraction(BigInteger a, int iter, int limit) {
		long nextValue = (iter % 3 == 2) ? 2 * (iter / 3 + 1) : 1;
		if(iter == limit) 
			return new BigInteger[] {BigInteger.ONE, a};
		else {
			BigInteger[] fraction = getFraction(BigInteger.valueOf(nextValue), iter + 1, limit);
			return new BigInteger[] {fraction[1], a.multiply(fraction[1]).add(fraction[0])};
		}
	}
}
