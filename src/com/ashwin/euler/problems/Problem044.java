package com.ashwin.euler.problems;

public class Problem044 {

	public static void main(String[] args) {
		System.out.println(getMinDifference());
	}
	
	public static int getMinDifference() {
		int n1 = 1;
		while(n1 > 0) {
			int p1 = getPentagonal(n1);
			
			for(int n2 = n1 - 1; n2 > 0; n2--) {
				int p2 = getPentagonal(n2);
				if(isPentagonal(p1 - p2) && isPentagonal(p1 + p2))
					return p1 - p2;
			}
			
			n1++;
		}
		return 0;
	}
	
	public static int getPentagonal(int n) {
		return n * (3 * n - 1) / 2;
	}
	
	// 3n^2 - n - 2 * num
	public static boolean isPentagonal(int num) {
		double val1 = (1 + Math.sqrt(1 + 24 * num)) / 6;
		return val1 == (int) val1;
	}
}
