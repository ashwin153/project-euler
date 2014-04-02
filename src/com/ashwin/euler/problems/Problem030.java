package com.ashwin.euler.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem030 {

	public static void main(String[] args) {
		Map<Integer, Integer> powers = new HashMap<Integer, Integer>();
		for(int i = 0; i <= 9; i++)
			powers.put(i, (int) Math.pow(i, 5));
		
		int digitLimit = 1;
		while(powers.get(9) * digitLimit > Math.pow(10, digitLimit))
			digitLimit++;

		int sum = 0;
		for(int i = 2; i <= Math.pow(10, digitLimit); i++) {
			String str = String.valueOf(i);
			
			int digitSum = 0;
			for(int j = 0; j < str.length(); j++)
				digitSum += powers.get((int) str.charAt(j) - 48);
			
			if(i == digitSum)
				sum += digitSum;
		}
		
		System.out.println(sum);
	}
}
