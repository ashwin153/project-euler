package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem029 {
	
	public static void main(String[] args) {
		List<Map<Integer, Integer>> numbers = new ArrayList<Map<Integer, Integer>>();
		for(int a = 2; a <= 100; a++) {
			Map<Integer, Integer> factorization = getPrimeFactorization(a);
			for(int b = 2; b <= 100; b++) {
				Map<Integer, Integer> multiple = new HashMap<Integer, Integer>(factorization);
				for(Integer key : multiple.keySet())
					multiple.put(key, multiple.get(key) * b);
				
				if(!numbers.contains(multiple))
					numbers.add(multiple);
			}
		}
		
		System.out.println(numbers.size());
	}
	
	public static Map<Integer, Integer> getPrimeFactorization(int num) {
		Map<Integer, Integer> factorization = new HashMap<Integer, Integer>();
		
		while(num != 1) {
			int primeFactor = getLargestPrimeFactor(num);
			int curVal = factorization.containsKey(primeFactor) ? factorization.get(primeFactor) : 0;
			factorization.put(primeFactor, curVal + 1);
			num /= primeFactor;
		}
		
		return factorization;
	}
	
	public static int getLargestPrimeFactor(int num) {
		for(int i = num; i >= 2; i--)
			if(num % i == 0 && isPrime(i))
				return i;
		return num;
	}
	
	public static boolean isPrime(int num) {
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
