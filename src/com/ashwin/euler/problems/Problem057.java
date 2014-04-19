package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem057 {

	/*
	 * 1 + 1/2		= 3/2		numerator 		= fractionNumerator + fractionDenominator
	 * 1 + 2/5		= 7/5		denominator		= fractionDenominator * 2 + numerator
	 * 1 + 5/12		= 17/12		fractionNumerator = lastDenominator
	 * 1 + 12/29	= 
	 * 1 + 29/70
	 * 1 + 70/169
	 * 1 + 169/408
	 */
	
	public static void main(String[] args) {
		
		BigInteger numerator = BigInteger.valueOf(1);
		BigInteger denominator = BigInteger.valueOf(2);
		
		int count = 0;
		for(int i = 1; i < 1000; i++) {
			if(numerator.add(denominator).toString().length() > denominator.toString().length())
				count++;
			
			BigInteger nextNumerator = denominator;
			BigInteger nextDenominator = numerator.add(denominator.multiply(BigInteger.valueOf(2)));
			numerator = nextNumerator;
			denominator = nextDenominator;
		}
		
		System.out.println(count);
	}
	
	
}
