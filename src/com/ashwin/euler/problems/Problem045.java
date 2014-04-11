package com.ashwin.euler.problems;

import java.math.BigInteger;

public class Problem045 {
	

	public static void main(String[] args) {
		int t = 287, p = 166;
		BigInteger vt = null, vp = null;
		
		// if t % 2 != 0, then it is a hexagonal number
		while((vt = getTriangular(t)).compareTo(vp = getPentagonal(p)) != 0) {
			if(vt.compareTo(vp) <= 0)
				t += 2;
			else
				p++;
		}
		
		System.out.println(vt);
	}
	
	public static BigInteger getTriangular(int n) {
		BigInteger val = BigInteger.valueOf(n);
		return val.multiply(val.add(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
	}
	
	public static BigInteger getPentagonal(int n) {
		BigInteger val = BigInteger.valueOf(n);
		return val.multiply(val.multiply(BigInteger.valueOf(3)).subtract(BigInteger.valueOf(1))).divide(BigInteger.valueOf(2));
	}
}
