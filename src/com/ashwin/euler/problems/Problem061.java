package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem061 {
	
	public static void main(String[] args) {
		List<List<Integer>> polygonals = getAllPolygonals();
		List<Integer> list = polygonals.get(0);
		String result = null;
		int counter = 0;
		
		while(counter < list.size() && (result = getResult(String.valueOf(
				list.get(counter)), polygonals, "0")) == null)
			counter++;
		
		System.out.println(getSum(result));
	}
	
	public static int getSum(String str) {
		int sum = 0;
		for(int j = 0; j < str.length(); j+= 4)
			sum += Integer.valueOf(str.substring(j, j + 4));
		return sum;
	}
	
	public static String getResult(String candidate, List<List<Integer>> polygonals, String usedLists) {
		String prefix = candidate.substring(0, 2);
		String suffix = candidate.substring(candidate.length() - 2);
		
		if(candidate.length() == 24 && prefix.equals(suffix)) return candidate;
		else if(candidate.length() == 24 || usedLists.length() == 6) return null;
		
		for(int i = 0; i < polygonals.size(); i++) {
			String listNumber = String.valueOf(i);
			if(!usedLists.contains(listNumber)) {
				List<Integer> list = polygonals.get(i);
				for(int j = 0; j < list.size(); j++) {
					String str = String.valueOf(list.get(j)), result = "";
					if(str.startsWith(suffix) && !candidate.contains(str) && 
							(result = getResult(candidate + str, polygonals, usedLists + listNumber)) != null)
						return result;
					if(str.endsWith(prefix) && !candidate.contains(str) &&
							(result = getResult(str + candidate, polygonals, usedLists + listNumber)) != null)
						return result;
				}
			}
		}
		
		return null;
	}
	
	public static List<List<Integer>> getAllPolygonals() {
		List<List<Integer>> polygonals = new ArrayList<List<Integer>>();
		for(int i = 0; i < 6; i++)
			polygonals.add(new ArrayList<Integer>());
		
		for(int i = 1000; i <= 9999; i++) {
			if(isTriangle(i))	polygonals.get(0).add(i);
			if(isSquare(i))		polygonals.get(1).add(i);
			if(isPentagonal(i))	polygonals.get(2).add(i);
			if(isHexagonal(i))	polygonals.get(3).add(i);
			if(isHeptagonal(i))	polygonals.get(4).add(i);
			if(isOctagonal(i))	polygonals.get(5).add(i);
		}
		
		return polygonals;
	}
	
	// Returns whether or not the number is a triangular,
	// square, hexagonal, heptagonal, or octagonal number
	public static boolean isTriangle(int num) {
		return isSolution(num, 0.5, 0.5);
	}
	
	public static boolean isSquare(int num) {
		return isSolution(num, 1, 0);
	}
	
	public static boolean isPentagonal(int num) {
		return isSolution(num, 1.5, -0.5);
	}
	
	public static boolean isHexagonal(int num) {
		return isSolution(num, 2, -1);
	}
	
	public static boolean isHeptagonal(int num) {
		return isSolution(num, 2.5, -1.5);
	}

	public static boolean isOctagonal(int num) {
		return isSolution(num, 3, -2);
	}
	
	// Returns whether or not the positive number is a solution
	// to the stated quadratic equation
	public static boolean isSolution(double num, double a, double b) {
		double val1 = (-b + Math.sqrt(b * b + 4 * a * num)) / (2 * a);
		return val1 == (int) val1;
	}
}
