package com.ashwin.euler.problems;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem013 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("assets/problem013.txt"));
		
		String sum = sum(scanner.nextLine(), scanner.nextLine());
		while(scanner.hasNextLine()) {
			sum = sum(sum, scanner.nextLine());
		}
		
		sum = trimZeros(sum);
		System.out.println(sum.substring(0, 10));
	}
	
	public static String trimZeros(String str) {
		while((int) str.charAt(0) == 48)
			str = str.substring(1);
		return str;
	}
	
	public static String zeroPad(String str, int length) {
		StringBuilder sb = new StringBuilder(str);
		for(int i = 0; i < length - str.length(); i++)
			sb.insert(0, 0);
		return sb.toString();
	}
	
	public static String sum(String str1, String str2) {
		int length = Math.max(str1.length(), str2.length());
		str1 = zeroPad(str1, length);
		str2 = zeroPad(str2, length);

		StringBuilder sb = new StringBuilder();
		int carryOver = 0;
		for(int i = str1.length() - 1; i >= 0; i--) {
			int val1 = str1.charAt(i) - 48;
			int val2 = str2.charAt(i) - 48;
			
			int total = val1 + val2 + carryOver;
			int result = total % 10;
			carryOver = total / 10;
			sb.insert(0, result);
		}
		sb.insert(0, carryOver);
		return sb.toString();
	}
}
