package com.ashwin.euler.problems;

public class Problem037 {
	
	public static void main(String[] args) {
		int num = 11, count = 0, sum = 0;
		while(count < 11) {
			String str = String.valueOf(num);
			
			boolean isTruncatable = true;
			for(int i = 0; i < str.length(); i++)
				if(!isPrime(Integer.valueOf(str.substring(i))) ||
						!isPrime(Integer.valueOf(str.substring(0, i + 1)))) {
					isTruncatable = false;
					break;
				}
				
			if(isTruncatable) {
				sum += num;
				count++;
			}
			
			num++;
		}
		
		System.out.println(sum);
	}
	
	public static boolean isPrime(int num) {
		if(num == 1) return false;
		
		for(int i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0)
				return false;
		return true;
	}
}
