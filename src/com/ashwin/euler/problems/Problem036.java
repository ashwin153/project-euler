package com.ashwin.euler.problems;

public class Problem036 {
	
	public static void main(String[] args) {
		int sum = 0;
		for(int i = 1; i < 1000000; i++)
			if(isPalindrome(String.valueOf(i)) && isPalindrome(Integer.toBinaryString(i)))
				sum += i;
		System.out.println(sum);
	}

	public static boolean isPalindrome(String str) {
		for(int i = 0; i < str.length() / 2; i++)
			if(str.charAt(i) != str.charAt(str.length() - i - 1))
				return false;
		return true;
	}
}
