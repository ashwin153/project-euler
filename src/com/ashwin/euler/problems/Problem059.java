package com.ashwin.euler.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Problem059 {
	
	// Some common words that should be present in most English texts. Add
	// more words as necessary to prune of candidates down.
	private static final String[] words = {"the", "and", "so", "but"};

	public static void main(String[] args) throws IOException {
		int[] letters = loadFile("assets/problem059.txt");
		int counter = 0;
		
		for(int a = 97; a <= 122; a++) {
			for(int b = 97; b <= 122; b++) {
				for(int c = 97; c <= 122; c++) {
					StringBuilder full = new StringBuilder();
					for(int i = 0; i < letters.length; i++) {
						int letter = letters[i];
						switch(counter % 3) {
							case 0: letter ^= a; break;
							case 1: letter ^= b; break;
							case 2: letter ^= c; break;
						}
						full.append((char) letter);
						counter++;
					}
					
					if(isDecrypted(full.toString())) {
						System.out.println(getLongValue(full.toString().toCharArray()));
						break;
					}
				}
			}
		}
	}
	
	public static boolean isDecrypted(String str) {
		StringBuilder sb = new StringBuilder();
		for(char letter : str.toLowerCase().toCharArray())
			if(letter >= 'a' && letter <= 'z')
				sb.append(letter);
		
		for(String word : words)
			if(!sb.toString().contains((word)))
				return false;
		return true;
	}
	
	public static int[] loadFile(String filename) throws IOException {
		InputStream in = new FileInputStream(new File(filename));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		in.close();
		
		String[] strs = new String(buffer, "UTF-8").split(",");
		int[] result = new int[strs.length];
		for(int i = 0; i < strs.length; i++)
			result[i] = Integer.valueOf(strs[i]);
		return result;
	}
	
	public static long getLongValue(char[] vals) {
		int sum = 0;
		for(char letter : vals)
			sum += letter;
		return sum;
	}
}
