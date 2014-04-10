package com.ashwin.euler.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Problem042 {
	
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream(new File("assets/problem042.txt"));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		
		String str = new String(buffer, "UTF-8");
		String[] arr = str.replaceAll("\"", "").split(",");
		
		int numTriangle = 0;
		for(String word : arr)
			if(isTriangleNumber(getWordValue(word)))
				numTriangle++;
		System.out.println(numTriangle);
	}
	
	public static int getWordValue(String word) {
		int sum = 0;
		for(int i = 0; i < word.length(); i++)
			sum += word.charAt(i) - 64;
		return sum;
	}

	public static boolean isTriangleNumber(int num) {
		double val1 = (-1 + Math.sqrt(1 + 4 * 1 * 2 * num)) / (2);
		double val2 = (-1 - Math.sqrt(1 + 4 * 1 * 2 * num)) / (2);
		return val1 == (int) val1 || val2 == (int) val2;
	}
}
