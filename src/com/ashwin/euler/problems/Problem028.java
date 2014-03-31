package com.ashwin.euler.problems;

public class Problem028 {

	public static void main(String[] args) {
		int sum = 1, counter = 1, length = 3;
		
		while(length <= 1001) {
			for(int i = 0; i < 4; i ++) {
				counter += length - 1;
				sum += counter;
			}
			
			length += 2;
		}
		
		System.out.println(sum);
	}
}
