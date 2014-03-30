package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem025 {

	public static void main(String[] args) {
		BigInteger limit = new BigInteger("10").pow(999);
		BigInteger b = new BigInteger("1");
		BigInteger a = new BigInteger("1");
		int termNumber = 3;
		
		while(limit.compareTo(a.add(b)) == 1) {
			BigInteger temp = b;
			b = a;
			a = temp.add(a);
			termNumber++;
		}
		
		System.out.println(a.add(b));
		System.out.println(termNumber);
	}
}
