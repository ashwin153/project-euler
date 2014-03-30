package com.ashwin.euler.problems;

import java.util.HashMap;
import java.util.Map;

public class Problem019 {
	
	private static final Map<Integer, Integer> daysPerMonth = new HashMap<Integer, Integer>(){{
		put(1, 31);
		put(2, 28);
		put(3, 31);
		put(4, 30);
		put(5, 31);
		put(6, 30);
		put(7, 31);
		put(8, 31);
		put(9, 30);
		put(10, 31);
		put(11, 30);
		put(12, 31);
	}};

	public static void main(String[] args) {
		int currentDay = 1, numSundays = 0;
		for(int year = 1900; year <= 2000; year++) {
			boolean isLeapYear = ((year % 100 == 0 && year % 400 == 0) || (year % 100 != 0) && year % 4 == 0) ? true : false;
			for(int month = 1; month <= 12; month++) {
				int numDays = daysPerMonth.get(month) + ((isLeapYear && month == 2) ? 1 : 0);
				int dayCounter = 1;
				while(dayCounter <= numDays) {
					if(currentDay == 0 && year >= 1901 && dayCounter == 1)
						numSundays++;
					
					currentDay = (currentDay + 1) % 7;
					dayCounter++;
				}
			}
		}
		
		System.out.println(numSundays);
	}
}
