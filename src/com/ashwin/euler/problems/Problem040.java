package com.ashwin.euler.problems;

public class Problem040 {

	public static void main(String[] args) {
		int product = 1;
		for(int power = 0; power <= 6; power++)
			product *= getDigit((int) Math.pow(10, power));
		System.out.println(product);
	}
	
	public static int getDigit(int place) {		
		int count = 0, modifier = 0;
		while((modifier = (int)(9 * Math.pow(10, count) * (count + 1))) < place) {
			place -= modifier;
			count++;
		}
		
		double number = place / (count + 1.0) + Math.pow(10, count) - 1;
		String str = String.valueOf((int) Math.ceil(number));
		return str.charAt(str.length() - 1 - (int) Math.round((Math.ceil(number) - number) / (1.0 / str.length()))) - 48;
	}
}
