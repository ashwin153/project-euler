package com.ashwin.euler.problems;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem067 {

	public static void main(String[] args) throws IOException {
		Scanner scanner = new Scanner(new File("assets/problem067.txt"));
		int[][] tree = new int[100][];
		
		for(int i = 0; i < tree.length; i++) {
			String[] vals = scanner.nextLine().split(" ");
			tree[i] = new int[vals.length];
			
			for(int j = 0; j < vals.length; j++)
				tree[i][j] = Integer.valueOf(vals[j]);
		}
		
		for(int i = tree.length - 2; i >= 0; i--)
			for(int j = 0; j < tree[i].length; j++)
				tree[i][j] = tree[i][j] + Math.max(tree[i+1][j], tree[i+1][j+1]);
		
		System.out.println(tree[0][0]);
	}
}
