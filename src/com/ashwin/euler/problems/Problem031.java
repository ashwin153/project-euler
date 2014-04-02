package com.ashwin.euler.problems;


public class Problem031 {

	public static void main(String[] args) {
		int[] coins = {1, 2, 5, 10, 20, 50, 100, 200};
		int totalValue = 200;
		
		long counter = 0;
		for(int a = totalValue; a >= 0; a -= 200)
			for(int b = a; b >= 0; b -= 100)
				for(int c = b; c >= 0; c -= 50)
					for(int d = c; d >= 0; d -= 20)
						for(int e = d; e >= 0; e -=10)
							for(int f = e; f >= 0; f -= 5)
								for(int g = f; g >= 0; g -= 2)
									counter++;
		System.out.println(counter);
	}
}
