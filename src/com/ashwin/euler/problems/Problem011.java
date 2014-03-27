package com.ashwin.euler.problems;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Problem011 {

	public static void main(String[] args) throws IOException {
		long[][] data = new long[20][20];
		Scanner scanner = new Scanner(new File("assets/problem011.txt"));
		for(int i = 0; i < data.length; i++)
			for(int j = 0; j < data[i].length; j++)
				data[i][j] = scanner.nextLong();
		
		long max = 0;
		for(int i = 0; i < data.length; i++) {
			for(int j = 0; j < data[i].length; j++) {
				long horizontal = (j < data[i].length - 3) ? data[i][j] * data[i][j+1] * data[i][j+2] * data[i][j+3] : -1;
				long vertical   = (i < data.length - 3)    ? data[i][j] * data[i+1][j] * data[i+2][j] * data[i+3][j] : -1;
				long diagonalRight = (j < data[i].length - 3 && i < data.length - 3) ? data[i][j] * data[i+1][j+1] * data[i+2][j+2] * data[i+3][j+3] : -1;
				long diagonalLeft  = (j > 3 && i < data.length - 3) ? data[i][j] * data[i+1][j-1] * data[i+2][j-2] * data[i+3][j-3] : -1;
				long greater = Math.max(Math.max(horizontal, vertical), Math.max(diagonalRight, diagonalLeft));
				if(greater > max)
					max = greater;
			}
		}
		
		System.out.print(max);
	}
}
