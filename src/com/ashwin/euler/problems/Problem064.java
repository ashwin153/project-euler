package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem064 {

	public static void main(String[] args) {
		int counter = 0;
		for(int N = 2; N <= 10000; N++) {
			double root = Math.sqrt(N);
			if(root != (int) root) {
				// Stores previous terms. If the terms list contains the
				// specified term, then we know we are repeating
				List<Double> terms = new ArrayList<Double>();
				
				// Term = a + (Math.sqrt(N) - b) / c
				// next a = Math.floor(Math.sqrt(N) - last b) / next c
				// next b = -last b - next a * next c
				// next c = (N - (last b)^2) / last c
				
				double term = 0, a = Math.floor(root), b = a, c = 1;
				while(!terms.contains((term = a + (root - b) / c))) {
					terms.add(term);
					
					c = (N - b * b) / c;
					a = Math.floor((root - b) / c);
					b = -b - a * c;
				}
				
				if((terms.size() - terms.indexOf(term)) % 2 != 0)
					counter++;
			}
		}
		
		System.out.println(counter);
	} 
}
