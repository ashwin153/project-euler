package com.ashwin.euler.problems;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Problem022 {

	public static void main(String[] args) throws IOException {
		InputStream in = new FileInputStream(new File("assets/problem022.txt"));
		byte[] buffer = new byte[in.available()];
		in.read(buffer);
		
		String[] names = new String(buffer, "UTF-8").replaceAll("\"", "").split(",");
		List<String> alphabetical = new ArrayList<String>();
		Collections.addAll(alphabetical, names);
		Collections.sort(alphabetical);
		
		long totalScore = 0;
		for(int i = 0; i < alphabetical.size(); i++) {
			String name = alphabetical.get(i);
			int nameScore = 0;
			for(int j = 0; j < name.length(); j++)
				nameScore += name.charAt(j) - 64;
			totalScore += nameScore * (i + 1);
		}
		
		System.out.println(totalScore);
	}
}
