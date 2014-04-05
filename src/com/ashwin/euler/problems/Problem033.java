package com.ashwin.euler.problems;

public class Problem033 {

	public static void main(String[] args) {
		int top = 1, bottom = 1;
		for(int a = 10; a <= 99; a++) {
			for(int b = a + 1; b <= 99; b++) {
				String numerator = String.valueOf(a);
				String denominator = String.valueOf(b);
				
				for(int i = 0; i < numerator.length(); i++) {
					String digit = String.valueOf(numerator.charAt(i));
					if(Integer.valueOf(digit) != 0 && denominator.contains(digit)) {
						Integer c = Integer.valueOf(numerator.replaceFirst(digit, ""));
						Integer d = Integer.valueOf(denominator.replaceFirst(digit, ""));
						
						if((double) a / b == (double) c / d) {
							top *= a;
							bottom *= b;
						}
					}
				}
			}
		}
		
		int gcf = -1;
		while((gcf = greatestCommonFactor(top, bottom)) != -1) {
			top /= gcf;
			bottom /= gcf;
		}
		
		System.out.println(bottom);
	}
	
	public static int greatestCommonFactor(int num1, int num2) {
		for(int i = 2; i <= num1 && i <= num2; i++)
			if(num1 % i == 0 && num2 % i == 0)
				return i;
		return -1;
	}
}
