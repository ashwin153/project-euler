package com.ashwin.euler.problems;

public class Problem039 {
	
	public static void main(String[] args) {
		int maxSolutions = 0, maxPerimeter = 0;
		for(int perimeter = 0; perimeter <= 1000; perimeter++) {
			double limit = perimeter / (2 + Math.sqrt(2));
			
			int solutions = 0;
			for(int a = 1; a <= limit; a++) {
				for(int b = (int) limit; b < perimeter; b++) {
					double c = Math.sqrt(a * a + b * b);
					if(a + b + c == perimeter)
						solutions++;
				}
			}
			
			if(solutions > maxSolutions) {
				maxSolutions = solutions;
				maxPerimeter = perimeter;
			}
		}
		
		System.out.println(maxPerimeter);
	}
}
