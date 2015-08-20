package com.ashwin.euler.problems;

/**
 * The problem asks for the number of ways that a number can be written as the
 * sum of at least two positive integers. If we think of a number as the sum of
 * 1's (4 = 1 + 1 + 1 + 1), then this problem is asking for the number of
 * distinct ways to group these 1's together. In other words, the problem is
 * looking for the number of ways to put indistinguishable objects (1's) into
 * indistinguishable bins (groups).
 * 
 * The number of ways to put indistinguishable objects into indistinguishable
 * bins is defined by the following recurrence relation: p(n, k) = p(n-1, k-1) +
 * p(n-k, k). The intuition behind this relation is explained on this website 
 * http://2000clicks.com/mathhelp/CountingObjectsInBoxesPartRecurrenceRelation.aspx
 * 
 * @author ashwin
 * 
 */
public class Problem076 {

	public static void main(String[] args) {
		long n = 100, sum = 0;
		for(long k = 2; k <= n; k++)
			sum += partitions(n, k);
		System.out.println(sum);
	}
	
	public static long partitions(long n, long k) {
		if(k > n)
			return 0;
		else if(k == 1 || n <= 3)
			return 1;
		return partitions(n - 1, k - 1) + partitions(n - k, k);
	}
}
