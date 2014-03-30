package com.ashwin.euler.problems;


public class Problem021 {

	public static void main(String[] args) {
		int amicableSum = 0;
		for(int i = 1; i <= 10000; i++) {
			int divisorSum = getProperDivisorSum(i);
			
			if(getProperDivisorSum(divisorSum) == i && divisorSum != i)
				amicableSum += i;
		}
		
		System.out.println(amicableSum);
	}
	
	public static int getProperDivisorSum(int number) {
		int divisorSum = 0;
		for(int i = 1; i < number; i++)
			if(number % i == 0)
				divisorSum += i;
		return divisorSum;
	}
}
