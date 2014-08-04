package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;


public class Problem76 {
	

}
	
//	public static void main(String[] args) {
//		List<Integer> numbers = new ArrayList<Integer>();
//		numbers.add(8);
//		
//		System.out.println(getNumberOfWays(numbers));
//	}
//	
//	public static int getNumberOfWays(List<Integer> numbers) {
//		int startIndex = getStartIndex(numbers);
//		if(startIndex == -1) return 1; // This means that all the numbers are 1
//		
//		numbers.set(startIndex, numbers.get(startIndex) - 1);
//		int replaceIndex = getReplaceIndex(startIndex, numbers);
//		
//		if(replaceIndex == -1)
//			numbers.add(1);
//		else
//			numbers.set(replaceIndex, numbers.get(replaceIndex) + 1);
//		
//		System.out.println(numbers);
//		return 1 + getNumberOfWays(numbers);
//	}
//	
//	// Finds the first index of a value less than the value at startIndex, or -1
//	// if no such index exists.
//	public static int getReplaceIndex(int startIndex, List<Integer> numbers) {
//		for(int i = startIndex + 1; i < numbers.size(); i++)
//			if(numbers.get(i) < numbers.get(startIndex))
//				return i;
//		return -1;
//	}
//	
//	// Finds the highest index of a number that is greater than the
//	// number to its right. If the last number is NOT 1, then it can be used.
//	public static int getStartIndex(List<Integer> numbers) {
//		int limit = numbers.size() - 1;
//		if(numbers.get(limit) > 1) return limit;
//		
//		for(int i = limit - 1; i >= 0; i--)
//			if(numbers.get(i) > numbers.get(i + 1))
//				return i;
//		return -1;
//	}
//}
//	
//	public static void main(String[] args) {
//		int limit = 5;
//		
//		// The number of unique ways to write limit as the sum of at least 2 positive integers.
//		// Begin at one, to account for last combination ie. 1 + 1 + 1 + 1 ...
//		long[] ways = new long[limit + 1];
//		
//		for(int i = 2; i < ways.length; i++) {
//			// The total number of ways to write this particular iteration
//			long total = 1L;
//			
//			for(int j = i - 1; j >= 2; j--) {
//				if(j >= i / 2.0)
//					total += ways[i - j] + 1;
//				
//				5 + 4 + 3 + 2
//					5 + 4 + 3 + 1 + 1
//				5 + 4 + 2 + 2 + 1
//					5 + 4 + 2 + 1 + 1 + 1
//					5 + 4 + 1 + 1 + 1 + 1 + 1
//				5 + 3 + 3 + 3
//					5 + 3 + 3 + 2 + 1
//				
//					
//			}
//			
//			ways[i] = total;
//			System.out.println(i + " " + total);
//		}
////	for(int number = 2; number < ways.length; number++) {
////	
////	long total = 1;
////	
////	for(int a = number - 1; a >= 2; a--) {
////		// Until we get to halfway, it is very simple. ie. number = 5, a = 3
////		// 3 + 2, find the ways to make 2 + 1 and add to total
////		if(a >= number / 2.0)
////			total += ways[number - a] + 1;
		
//		1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1 + 1
//		
//		for(int groupSize = 1; groupSize < limit; groupSize++)
//			
//		int groupSize = 1;
		

	
//	public static void main(String[] args) {
//		int limit = 4, ways = 1;
//		for(int a = limit - 1; a >= 2; a++) {
//			// Initialize the list of numbers
//			List<Integer> numbers = new ArrayList<Integer>();
//			for(int i = 0; i < (limit - a) / a; i++)
//				numbers.add(a);
//			
//			if((limit - a) % a != 0)
//				numbers.add((limit - a) % a);
//			
//			ways += getUniqueWays(numbers);
//		}
//		
//		System.out.println(ways);
////		long[] ways = new long[101];
////		for(int number = 2; number < ways.length; number++) {
////			// Begin at one, to account for last combination ie. 1 + 1 + 1 + 1 ...
////			long total = 1;
////			
////			for(int a = number - 1; a >= 2; a--) {
////				// Until we get to halfway, it is very simple. ie. number = 5, a = 3
////				// 3 + 2, find the ways to make 2 + 1 and add to total
////				if(a >= number / 2.0)
////					total += ways[number - a] + 1;
////				
////				// After halfway it becomes slightly more complicated
////				else {
////					List<Integer> values = new ArrayList<Integer>();
////					for(int i = 0; i < (number - a) / a; i++)
////						values.add(a);
////					
////					if((number - a) % a != 0)
////						values.add((number - a) % a);
////					
////					// For the combination a + 1 + 1 + 1 + 1 + 1 ...
////					total++;
////				}
////			}
////		}
//	}
//	
//	// Returns the index of the first term with a number less than it to its right, or
//	// returns the last term if the last term is greater than 1
//	public static int getIndex(List<Integer> numbers) {
//		for(int i = 0; i < numbers.size(); i++)
//			if(i < numbers.size() - 1 && numbers.get(i + 1) < numbers.get(i) ||
//					i == numbers.size() - 1 && numbers.get(i) > 1)
//				return i;
//		return -1;
//	}
//	
//	// getUniqueWays 7 + 1
//	// getUniqueWays 6 + 2, getUniqueWays 6 + 1 + 1
//	public static int getUniqueWays(List<Integer> numbers) {
//		int index = getIndex(numbers);
//		if(index != -1) {
//			numbers.set(index, numbers.get(index) - 1);
//			ways++;
//			
//			for(int i = index + 1; i <= numbers.size(); i++) {
//				
//			}
//		}
		
//		int index = getIndex(numbers);
//		int ways = 0;		
//		
//		if(index != -1) {
//			numbers.set(index, numbers.get(index) - 1);
//			ways++;
//			
//			for(int i = index + 1; i <= numbers.size(); i++) {
//				if(i == numbers.size() || numbers.get(i) != numbers.get(i - 1)) {
//					List<Integer> list = new ArrayList<Integer>(numbers);
//					if(i == list.size()) list.add(1);
//					else if(list.get(i) + 1 <= numbers.get(index)) list.set(i, list.get(i) + 1);
//					ways += getUniqueWays(list);
//				}
//			}
//		}
//		
//		return ways;
//	}
//}
//		if(a == 1)
//			return 0;
//		
//		for(int i = 0; i < (limit - a) / a; i++)
//			numbers.add(a);
//		
//		if((limit - a) % a != 0)
//			numbers.add((limit - a) % a);
//		
//		for(int)
//		
//		return getUniqueWays(a--, new ArrayList<Integer>());
//	}
//}
//	public static void main(String[] args) {
////		a + b (total += how many ways to divide up b + 1)
////		a + b + c + d(total += how many ways to divide up b + c + d + 1)
//		
//		long[] ways = new long[101];
//		
//		for(int number = 2; number < ways.length; number++) {
//			long total = 1;
//
//			for(int a = number - 1; a >= 2; a--) {
//				// Until we get to halfway, it is very simple. ie. number = 5, a = 3
//				// 3 + 2, find the ways to make 2 + 1 and add to total
//				if(a >= number / 2.0)
//					total += ways[number - a] + 1;
//				
//								
////				// After the half way point. ie. number = 18, a = 5
////				// we can think of 5 + 5 + 5 + 3 as 15 + 3, then 14 + 4, then 
////				else {
////					int b = number - a;
////					total++;
////					for(int i = 1; i <= b / a; i++) {
////						total += ways[b - i * a] + 1;
////					}
////					
////				}
//
//			}
//			
//			System.out.println(number + " " + total);
//
//		}
//	}
//}
			
			
			/*
			4 + 4 + 2
			4 + 3 + 3
			4 + 3 + 2 + 1
			
			4 + 2 + 2 + 2
			4 + 2 + 2 + 1 + 1
			4 + 2 + 1 + 1 + 1 + 1
			4 + 1 + 1 + 1 + 1 + 1 + 1
			
			5 + 4 + 4 + 4
			5 + 4 + 4 + 3 + 1
				5 + 4 + 3 + 3 + 2
				5 + 4 + 3 + 2 + 2 + 1
				5 + 4 + 3 + 2 + 1 + 1 + 1
				5 + 4 + 3 + 1 + 1 + 1 + 1 + 1
				5 + 4 + 2 + 2 + 1 + 1 + 1 + 1
				5 + 4 + 2 + 1 + 1 + 1
				5 + 4 + 2 + 2 + 2 + 2
			5 + 4 + 4 + 2 + 2
			5 + 4 + 4 + 2 + 1 + 1
			5 + 4 + 4 + 1 + 1 + 1 +1
			
			
			5 + 4 + 4 + 2 + 1 + 1
			5 + 4 + 4 + 
			5 + 4 + 3 + 3 + 2
			5 + 3 + 3 + 3 + 3
			
			ways[number] = total;
			System.out.println(number + ": "+ ways[number]);
			
//			for(int a = number - 1; a >= 1; a--) {
//				int b = number - a;
//				
//				// ie. number = 5, a = 2, b = 3 - subdivide b into 2 and 1
//				if(b > a)
//					total += (b / a) * ways[a] + ways[b % a] + b(Math.pow(ways[a], b / a) * ways[b % a]);
//				else
//					total += ways[b] + 1;
//			}
//			
//			ways[number] = total;
//			System.out.println(number + ": "+ ways[number]);
		}
		
		// 5 + 5 + 5 + 4, 5 + 5 + 5 + 3 + 1, 5 + 5 + 5
			
		//8:  (7 + 1) (6 + 2) (6 + 1 + 1) (5 + 3) (5 + 2 + 1) (5 + 1 + 1 + 1) (4 + 4) (4 + 3 + 1) (4 + 2 + 2) (4 + 2 + 1 + 1) (4 + 1 + 1 + 1 + 1) (3 + 3 + 2) (3 + 3 + 1 + 1) (3 + 2 + 2 + 1) (3 + 2 + 1 + 1 + 1) (3 + 1 + 1 + 1 + 1 + 1) (2 + 2 + 2 + 2) (2 + 2 + 2 + 1 + 1) (2 + 2 + 1 + 1 + 1 + 1) (2 + 1 + 1 + 1 + 1 + 1 + 1)(1 + 1 + 1 + 1 + 1 + 1 + 1 + 1)
		
		//6: 10 (5 + 1) (4 + 2) (4 + 1 + 1) (3 + 3) (3 + 2 + 1) (3 + 1 + 1 + 1) (2 + 2 + 2) (2 + 2 + 1 + 1) (2 + 1 + 1 + 1 + 1) (1 + 1 + 1 + 1 + 1 + 1)
		//5: 6 (4 + 1) (3 + 2) (3 + 1 + 1) (2 + 2 + 1) (2 + 1 + 1 + 1) (1 + 1 + 1 + 1 + 1)
		//4: 4 (3 + 1) (2 + 2) (2 + 1 + 1) (1 + 1 + 1 + 1)
		//3: 2 (2 + 1) (1 + 1 + 1)
		//2: 1 (1 + 1)
		//1: 0
	}
	
//	/**
//	 * How many ways can 100 be written as the sum of at least 2 positive numbers?
//	 */
//	public static void main(String[] args) {
//		int val = 5;
//		long total = 0;
//		for(int i = val - 1; i >= 2; i--) {
//			List<Integer> numbers = new ArrayList<Integer>();
//			if(i >= val - i) {
//				// For all values greater than half of the number, do the following
//				numbers.add(i);
//				numbers.add(val - i);
//			} else {
//				double quotient = (double) val / i;
//				for(int j = 0; j < quotient; j++)
//					numbers.add(i);
//				if(quotient != (int) quotient)
//					numbers.add((val - i) % i);
//			} 
//			
//			
//			System.out.println(numbers);
//			total++;
//			while(numbers.get(1) != 1) {
//				// Find the first non-one term, that is NOT the first number
//				int place = numbers.size() - 1;
//				while(place > 0 && numbers.get(place) == 1)
//					place--;
//				
//				if(numbers.get(place) == 2) {
//					// If the value is a two, the split into into two ones
//					numbers.remove(place);
//					numbers.add(1);
//					numbers.add(1);
//				} else {
//					// Otherwise subtract one from the value and increment/add
//					// one to the next column.
//					numbers.set(place, numbers.get(place) - 1);
//					
//					if(place == numbers.size() - 1)
//						numbers.add(1);
//					else
//						numbers.set(place+1, numbers.get(place+1) + 1);
//				}
//				
//				System.out.println(numbers);
//				total++;
//			}
//		}
//		
//		//190569291
//		// Add 1 at the end for the 1 + 1 + 1... term, which is not counted
//		System.out.println(total);
//	}
//}
