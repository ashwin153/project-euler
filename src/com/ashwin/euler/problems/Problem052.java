package com.ashwin.euler.problems;

public class Problem052 {
	
	public static void main(String[] args) {
		int counter = 1;
		
		while(counter > 0) {
			boolean isSolution = true;
			for(int i = 2; i <= 6; i++) {
				if(!arePermutations(counter, i * counter)) {
					isSolution = false;
					break;
				}
			}
			
			if(isSolution) {
				System.out.println(counter);
				break;
			}
			
			counter++;
		}
	}

	public static boolean arePermutations(int n1, int n2) {
		String str1 = String.valueOf(n1);
		String str2 = String.valueOf(n2);
		
		if(str1.length() != str2.length()) return false;
		
		for(int i = 0; i < str1.length(); i++)
			str2 = str2.replaceFirst(String.valueOf(str1.charAt(i)), "");
		
		return str2.isEmpty();
	}
}
