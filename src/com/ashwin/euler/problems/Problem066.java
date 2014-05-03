package com.ashwin.euler.problems;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Problem066 {

	public static void main(String[] args) {
		BigInteger max = BigInteger.ZERO;
		int maxD = 0;

		for (int D = 2; D <= 1000; D++) {
			double root = Math.sqrt(D);
			if (root != (int) root) {
				List<BigInteger> continued = getContinuedFraction(D);
				BigInteger x = BigInteger.ZERO, y = BigInteger.ZERO;
				BigInteger[] result = null;

				int limit = 1;
				while ((result = getFraction(continued.get(0),
						continued.subList(1, continued.size()), 0, limit)) != null
						&& (x = result[1]).compareTo(BigInteger.ZERO) > 0
						&& (y = result[0]).compareTo(BigInteger.ZERO) > 0
						&& !isSolution(x, y, D))
					limit++;

				if (x.compareTo(max) > 0) {
					max = x;
					maxD = D;
				}
			}
		}

		System.out.println(maxD);
	}

	public static boolean isSolution(BigInteger x, BigInteger y, int D) {
		return x.pow(2).subtract(y.pow(2).multiply(BigInteger.valueOf(D)))
				.compareTo(BigInteger.ONE) == 0;
	}

	public static List<BigInteger> getContinuedFraction(double N) {
		List<BigInteger> values = new ArrayList<BigInteger>();
		List<Double> terms = new ArrayList<Double>();
		double term = 0, root = Math.sqrt(N), a = Math.floor(root), b = -a, c = 1;
		while (!terms.contains((term = a + (root - b) / c))) {
			terms.add(term);

			values.add(BigInteger.valueOf((long) a));
			c = (N - b * b) / c;
			a = Math.floor((root - b) / c);
			b = -b - a * c;
		}

		return values;
	}

	public static BigInteger[] getFraction(BigInteger a,
			List<BigInteger> continued, int iter, int limit) {
		BigInteger nextValue = continued.get(iter % continued.size());
		if (iter == limit)
			return new BigInteger[] { BigInteger.ONE, a };
		else {
			BigInteger[] fraction = getFraction(nextValue, continued, iter + 1,
					limit);
			return new BigInteger[] { fraction[1],
					a.multiply(fraction[1]).add(fraction[0]) };
		}
	}
}
