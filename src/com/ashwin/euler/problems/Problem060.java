package com.ashwin.euler.problems;

import java.util.ArrayList;
import java.util.List;

public class Problem060 {
	
	public static void main(String[] args) {
		long limit = 8400L, startTimeMillis = System.currentTimeMillis();
		List<PrimePair> pairs = new ArrayList<PrimePair>();
		List<Long> primes = getAllPrimes(limit);
		
		for(int i = 0; i < primes.size() - 1; i++) {
			long n1 = primes.get(i);
			for(int j = i + 1; j < primes.size(); j++) {
				long n2 = primes.get(j);
				
				for(PrimePair pair : pairs) {
					if(pair.add(n2) && pair.size() == 5) {
						System.out.println(pair.getSum());
						System.out.println(System.currentTimeMillis() - startTimeMillis + " millis");
						return;
					}
				}
				
				if(PrimePair.isMember(n1, n2))
					pairs.add(new PrimePair(n1, n2));
			}
		}
		
//		System.out.println(pairs.size());
	}
	
	public static List<Long> getAllPrimes(long limit) {
		List<Long> primes = new ArrayList<Long>();
		for(long i = 2; i <= limit; i++)
			if(isPrime(i))
				primes.add(i);
		return primes;
	}

	public static boolean isPrime(long num) {
		if(num == 1) return false;
		
		for(long i = 2; i <= Math.sqrt(num); i++)
			if(num % i == 0L)
				return false;
		return true;
	}
	
	private static class PrimePair {
		
		private List<Long> pairs;
		
		public PrimePair(long n1, long n2) {
			pairs = new ArrayList<Long>();
			pairs.add(n1);
			pairs.add(n2);
		}
		
		public long getSum() {
			long sum = 0;
			for(Long pair : pairs)
				sum += pair;
			return sum;
		}
		
		public boolean add(long num) {
			if(isMember(num))
				return pairs.add(num);
			return false;
		}
		
		public int size() {
			return pairs.size();
		}
		
		public static boolean isMember(long n1, long n2) {
			String val1 = String.valueOf(n1);
			String val2 = String.valueOf(n2);
			
			return isPrime(Long.valueOf(val1 + val2)) && isPrime(Long.valueOf(val2 + val1));
		}
		
		public boolean isMember(long num) {
			String n2 = String.valueOf(num);
			for(Long pair : pairs) {
				String n1 = String.valueOf(pair);
				if(!n1.equals(n2) && !isPrime(Long.valueOf(n1 + n2)) || !isPrime(Long.valueOf(n2 + n1))) 
					return false;
			}
			return true;
		}
		@Override
		public String toString() {
			return pairs.toString();
		}
	}
}
