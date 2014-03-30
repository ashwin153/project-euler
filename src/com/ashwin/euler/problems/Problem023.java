package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem023 {

	private static final int limit = 28123;
	
	public static void main(String[] args) {
		List<Integer> abundant = new ArrayList<Integer>();
		for(int i = 1; i < limit; i++) {
			if(getSumOfProperDivisors(i) > i)
				abundant.add(i);
		}
		
		boolean[] canBeAbundantSum = new boolean[limit + 1];
		for(int i = 0; i < abundant.size(); i++)
			for(int j = 0; j < abundant.size(); j++)
				if(abundant.get(i) + abundant.get(j) <= limit)
					canBeAbundantSum[abundant.get(i) + abundant.get(j)] = true;
		
		int sum = 0;
		for(int i = 0; i < canBeAbundantSum.length; i++)
			if(!canBeAbundantSum[i])
				sum += i;
		System.out.println(sum);
	}
	
	public static int getSumOfProperDivisors(int number) {
		int sum = 0;
		for(int i = 1; i < number; i++)
			if(number % i == 0)
				sum += i;
		return sum;
	}
}
