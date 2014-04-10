package com.ashwin.euler.problems;

// 932718654
public class Problem038 {
	
	public static void main(String[] args) {
		int largestPandigital = 0, num = 1; 
		
		while(String.valueOf(num).length() + String.valueOf(num *2).length() <= 9) {
			StringBuilder concatProduct = new StringBuilder();
			int n = 1;
			
			while(concatProduct.length() < 9) {
				concatProduct.append(num * n);
				n++;
			}
			
			if(concatProduct.length() == 9 && isPandigital(concatProduct.toString()) && 
					Integer.valueOf(concatProduct.toString()) > largestPandigital)
				largestPandigital = Integer.valueOf(concatProduct.toString());
			
			num++;
		}
		
		System.out.println(largestPandigital);
	}
	
	public static boolean isPandigital(String str) {
		String num = "123456789";
		
		for(String digit : str.split("{0}"))
			num = num.replaceFirst(digit, "");
		
		return str.length() == 9 && num.isEmpty();
	}
}
