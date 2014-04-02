package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem032 {

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<Integer>();
		Collections.addAll(numbers, new Integer[] {1, 2, 3, 4, 5, 6, 7, 8, 9});
		long startTimeMillis = System.currentTimeMillis();
		List<Integer> products = new ArrayList<Integer>();
		
		// Code is zero based, so position - 1
		for(int position = 0; position < factorial(numbers.size()); position++) {
			List<Integer> numList = new ArrayList<Integer>(numbers);
			int curPosition = position;
			
			String result = new String("");
			for(int i = 0; i < numbers.size(); i++) {
				double value = factorial(numbers.size() - i) / (numbers.size() - i);
				result += numList.remove((int)((curPosition) / value));
				curPosition %= value;
			}
			
			for(int i = 1; i < result.length() / 2; i++) {
				for(int j = (result.length() - i) / 2; j >= i; j--) {
					int a = Integer.valueOf(result.substring(0, i));
					int b = Integer.valueOf(result.substring(i, i + j));
					int c = Integer.valueOf(result.substring(i + j));
					
					if(a * b == c && !products.contains(c))
						products.add(c);
				}
			}
		}
		
		int sum = 0;
		for(Integer product : products)
			sum += product;
		
		System.out.println("Sum: " + sum);
		System.out.println("Time: " + (System.currentTimeMillis() - startTimeMillis) + " ms");
	}
	
	public static int factorial(int num) {
		int factorial = 1;
		for(int i = 2; i <= num; i++)
			factorial *= i;
		return factorial;
	}
}
