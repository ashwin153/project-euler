package com.ashwin.euler.problems;

// http://projecteuler.net/problem=4
public class Problem004 {

	public static void main(String[] args) {
		int largestPalindrome = -1;
		
		for(int i = 100; i < 999; i++)
			for(int j = 100; j < 999; j++)
				if(isPalindrome(i * j) && i * j > largestPalindrome)
					largestPalindrome = i * j;
		
		System.out.println(largestPalindrome);
	}
	
	public static boolean isPalindrome(int num) {
		String str = String.valueOf(num);
		
		for(int i = 0; i < str.length() / 2; i++)
			if(str.charAt(i) != str.charAt(str.length() - 1 - i))
				return false;
		return true;
	}
}
