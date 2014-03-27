package com.ashwin.euler.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Problem008 {
	
	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream(new File("assets/problem8.txt"));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		String str = new String(buffer, "UTF-8").replaceAll("[^0-9]", "");
		
		int max = 0;
		for(int i = 0; i < str.length() - 4; i++) {
			int product = Integer.valueOf("" + str.charAt(i + 0)) *
						  Integer.valueOf("" + str.charAt(i + 1)) *
						  Integer.valueOf("" + str.charAt(i + 2)) *
						  Integer.valueOf("" + str.charAt(i + 3)) *
						  Integer.valueOf("" + str.charAt(i + 4));
			
			if(product > max)
				max = product;
		}
		
		System.out.println(max);
	}
}
