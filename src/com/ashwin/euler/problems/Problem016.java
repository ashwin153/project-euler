package com.ashwin.euler.problems;

import java.util.ArrayList;


public class Problem016 {

	public static void main(String[] args) {
		System.out.println(sum(1000));
	}
	
	public static int sum(int power) {
		ArrayList<Integer> digits = new ArrayList<Integer>();
		digits.add(1);
		
		for(int i = 1; i <= power; i++) {			
			for(int k = 0; k < digits.size(); k++)
				digits.set(k, digits.get(k) * 2);
			
			for(int j = digits.size() - 1; j >= 0; j--)
				if(digits.get(j) >= 10) {
					digits.set(j, digits.get(j) % 10);
					
					if(j == 0)
						digits.add(0, 1);
					else
						digits.set(j - 1, digits.get(j - 1) + 1);
				}
		}
		
		int digitSum = 0;
		for(Integer digit : digits)
			digitSum += digit;
		return digitSum;
	}
}
