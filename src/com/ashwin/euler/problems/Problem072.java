package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem072 {
	
//	The answer is the millionth prime - 2, solution to the Farey Sequence
	public static void main(String[] args) {
		List<Long> numbers = new ArrayList<Long>();
		int limit = 1000000;
		for(long i = 0; i <= limit; i++)
			numbers.add(i);
		
		long result = 0;
		for(int i = 2; i <= limit; i++) {
			if(numbers.get(i) == i)
				for(int j = i; j <= limit; j += i)
					numbers.set(j, numbers.get(j) * (i - 1) / i);
			result += numbers.get(i);
		}
		
		System.out.println(result);
	}
	
}
