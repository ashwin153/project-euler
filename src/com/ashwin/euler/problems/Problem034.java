package com.ashwin.euler.problems;

public class Problem034 {
	
	public static void main(String[] args) {
		int numDigits = 1, sum = 0;
		while(numDigits * factorial(9) > Math.pow(10, numDigits))
			numDigits++;
		
		for(int i = 3; i <= Math.pow(10, numDigits); i++) {
			String str = String.valueOf(i);
			int factorialSum = 0;
			for(int j = 0; j < str.length(); j++)
				factorialSum += factorial((int) str.charAt(j) - 48);
			
			if(factorialSum == i)
				sum += i;
		}
		
		System.out.println(sum);
	}

	public static int factorial(int num) {
		int factorial = 1;
		for(int i = 2; i <= num; i++)
			factorial *= i;
		return factorial;
	}
}
