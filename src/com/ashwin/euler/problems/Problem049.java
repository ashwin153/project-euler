package com.ashwin.euler.problems;

public class Problem049 {

	public static void main(String[] args) {
		System.out.println(getPrimePermutations());
	}
	
	public static String getPrimePermutations() {
		for(int i = 1000; i <= 9999; i++) {
			if(i != 1487 && isPrime(i)) {
				for(int dif = 1; dif <= (9999 - i) / 2; dif++) {
					if(isPermutation(i, i + dif) && isPermutation(i, i + 2 * dif) &&
						isPrime(i + dif) && isPrime(i + 2 * dif))
						return String.valueOf(i) + String.valueOf(i + dif) + String.valueOf(i + 2 * dif);
				}
			}
		}
		
		return null;
	}
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
	
	public static boolean isPermutation(int n1, int n2) {
		String str1 = String.valueOf(n1);
		String str2 = String.valueOf(n2);
		
		if(str1.length() != str2.length())
			return false;
		
		for(int i = 0; i < str1.length(); i++)
			str2 = str2.replaceFirst(String.valueOf(str1.charAt(i)), "");
		return str2.isEmpty();
	}
}
