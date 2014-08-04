package com.ashwin.euler.problems;


public class Problem075 {

	/**
	 * Find all the integers less than 1.5 million that are the perimeter 
	 * of only 1 Pythagorean Triangle.
	 * 
	 * Pythagorean Formula: a^2 + b^2 = c^2
	 * For a, b, and c to be integers:
	 * 		a^2 + b^2 must be a perfect square
	 *		a^2 must be a perfect square
	 *		b^2 must be a perfect square
	 *
	 * To find distinct perimeters
	 * 		a + b + c must be distinct
	 * 
	 * 		pick a C such that C^2 < 1.5 million
	 * 		pick a B such that B < root(1.5 million - C^2)
	 * 		pick a A such that A < B < C
	 */
	public static void main(String[] args) {
		// Option 1: Find all the Pythagorean Triples, find the perimeters, and
		// determine which perimeters have only one triple associated
		
		/*
		 * Pythagorean Triple (a, b, c) is primitive if (a, b, c) are coprime
		 * If triple is primitive, (ka, kb, kc) are also triples
		 * 
		 * a = m2 - n2, b = 2mn, c = m2 + n2
		 * 
		 * perimeter = m2 - n2 + 2mn + m2 + n2 = 2m2 + 2mn
		 * perimeter <= limit
		 * 
		 * upper bound calculation:
		 * 2m2 + 2mn = limit		to maximize m, n must be 1
		 * 2m2 + 2m - limit = 0		apply quadratic formula
		 * m = (-2 +- Math.sqrt(4 + 4 * 2 * limit)) / 4;
		 */
		
		int limit = 1500000;
		int[] perimeters = new int[limit + 1];
		
		double upper = (-2.0 + Math.sqrt(4.0 + 4.0 * 2.0 * limit)) / 4.0;
		for(int m = 2; m <= upper; m++) {
			for(int n = (m % 2 == 0) ? 1 : 2; n < m; n += 2) {
				if(isRelativelyPrime(m, n)) {
					int a = m * m - n * n;
					int b = 2 * m * n;
					int c = m * m + n * n;
					
					int perimeter = a + b + c;
					for(int k = 1; k <= limit / perimeter; k++) {
						perimeters[k * perimeter]++;
					}
				}
			}
		}
	
		int total = 0;
		for(int i = 0; i < perimeters.length; i++)
			if(perimeters[i] == 1)
				total++;
		System.out.println(total);
		
		// Option 2: Test each perimeter, see which ones have one triangle associated
		// (1.5 million iterations, not really feasible)
	}
	
	//Euclid's Algorithm for Greatest Common Denominator, if the GCD is
	//equal to 1, then the numbers are relatively prime. (not used)
	public static boolean isRelativelyPrime(int num1, int num2) {
		if(num1 == 0 || num2 == 0)
			return num1 == 1 || num2 == 1;
		
		if(num1 > num2)
			return isRelativelyPrime(num1 % num2, num2);
		else
			return isRelativelyPrime(num1, num2 % num1);
	}
}