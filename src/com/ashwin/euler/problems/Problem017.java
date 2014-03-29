package com.ashwin.euler.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem017 {


	private static final Map<Integer, String> numbers = new HashMap<Integer, String>() {{
	        put(1, "one");
	        put(2, "two");
	        put(3, "three");
	        put(4, "four");
	        put(5, "five");
	        put(6, "six");
	        put(7, "seven");
	        put(8, "eight");
	        put(9, "nine");
	        put(10, "ten");
	        put(11, "eleven");
	        put(12, "twelve"); 
	        put(13, "thirteen");
	        put(14, "fourteen"); 
	        put(15, "fifteen"); 
	        put(16, "sixteen"); 
	        put(17, "seventeen"); 
	        put(18, "eighteen"); 
	        put(19, "nineteen"); 
	        put(20, "twenty");
	        put(30, "thirty"); 
	        put(40, "forty");
	        put(50, "fifty"); 
	        put(60, "sixty"); 
	        put(70, "seventy"); 
	        put(80, "eighty"); 
	        put(90, "ninety");
	}};
	
	
	public static void main(String[] args) {
		int numLetters = 0;
		for(int hundred = 0; hundred <= 9; hundred++) {
			for(int ten = 0; ten <= 9; ten++) {
				for(int one = 0; one <= 9; one++) {
					String number = "";
					
					if(hundred != 0)
						number += numbers.get(hundred) + "hundred";
					if(hundred != 0 && (ten > 0 || one > 0))
						number += "and";
					
					if(ten == 1)
						number += numbers.get(ten * 10 + one);
					else if(ten > 1)
						number += numbers.get(ten * 10);
					
					if(ten != 1 && one != 0)
						number += numbers.get(one);
					
					System.out.println(number);
					numLetters += number.length();
				}
			}
		}
		numLetters += "onethousand".length();
		System.out.println(numLetters);
	}
}
