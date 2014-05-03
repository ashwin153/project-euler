package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Problem068 {

	public static void main(String[] args) {
		// 9	4,2,3; 5,3,1; 6,1,2
		// third digit of term1 = second digit of term 2
				
		// Term consists of three numbers: a, b, c
		// 	- Term 1 = a, b, c
		//	- Term 2 = d, c, e
		//	- Term 3 = f, e, g
		// 	- Term 4 = h, g, i
		//	- Term 5 = j, i, b
		// a MUST be the smallest number
		
		// select b, c, e
		// permutations 6 P 3 = 120 options
		// (later on it will be 10 P 3 or 720 options)
		
		// to ensure a is smallest
		// b + c > c + e && b + c > e + g && b + c > g + i && b + c > i + b
		// b > e && c > i
	
		int lower = 13, upper = 27;
		long max = 0L;
		
		for(int b = 1; b <= 10; b++) {
			for(int c = 1; c <= 10; c++) {
				if(b == c) continue;
				
				for(int e = 1; e < b; e++) {
					for(int g = 1; g <= 10 && g < b + c - e ; g++) {
						if(g == b || g == c || g == e) continue;
						
						for(int i = 1; i <= 10 && i < b + c - g && i < c; i++) {
							if(i == b || i == c || i == g || i == e) continue;
							
							for(int value = lower; value <= upper; value++) {
								int a = value - (b + c);
								int d = value - (c + e);
								int f = value - (e + g);
								int h = value - (g + i);
								int j = value - (i + b);
								
								List<Integer> values = new ArrayList<Integer>(Arrays.asList(a, b, c, d, e, f, g, h, i, j));
								if(!isTerm(values)) {
									List<Integer> term = Arrays.asList(a, b, c, d, c , e, f, e, g, h, g, i, j, i , b);
									String str = term.toString().replaceAll("\\D", "");
									
									if(str.length() == 16 && Long.valueOf(str) > max)
										max = Long.valueOf(str);
//									System.out.println(a+","+b+","+c+"; "+d+","+c+","+e+"; "+f+","+e+","+b+"; "+h+","+g+","+i+"; "+j+","+i+","+b);
								}
							}
						}
					}
				}
			}
		}
		
		System.out.println(max);
	}
	
	public static boolean isTerm(List<Integer> list) {
		Set<Integer> duplicates = new HashSet<Integer>();
		for(Integer value : list)
			if(value <= 0 || !duplicates.add(value))
				return true;
		return false;
	}
}

// to ensure a is the smallest, b + c > c + e && b + c > b + e
// c > e && b > e SO e MUST be the smallest number of the three
// b -> 1 to 6
// c -> 1 to 6 AND not b
// e -> 1 to 6 AND less than b AND less than c

// WORKS FOR 3!
//int min = 9, max = 12, limit = 6;
//for(int b = 1; b <= limit; b++) {
//	for(int c = 1; c <= limit; c++) {
//		if(c != b) {
//			for(int e = 1; e <= limit && e < b && e < c; e++) {
//				for(int i = min; i <= max; i++) {
//					int a = i - (b + c);
//					int d = i - (c + e);
//					int f = i - (e + b);
//				
//					List<Integer> digits = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 5, 6));
//					List<Integer> values = new ArrayList<Integer>(Arrays.asList(a, b, c, d, e, f));
//					digits.removeAll(values);
//					
//					if(digits.isEmpty())
//						System.out.println(a+","+b+","+c+"; "+d+","+c+","+e+"; "+f+","+e+","+b);
//				}
//			}
//		}
//	}
//}