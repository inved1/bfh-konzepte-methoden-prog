package ex04;

import java.math.BigInteger;

import misc.MyTimer;

/**
 * Class that contains several implementations to calculate the Fibonacci
 * numbers using iterative, recursive and mathematical algorithms.
 * 
 * @author simon
 * @since 12.04.2012
 * 
 */
public class Fibonacci {

	/**
	 * Cache size for fibonacciMem(), must be larger than argument of that
	 * method.
	 */
	private static final int CACHE_SIZE = Integer.MAX_VALUE;

	/**
	 * Initialize cache
	 */
	private static BigInteger cache[] = new BigInteger[CACHE_SIZE];

	/**
	 * Iterative method to compute the n-th Fibonacci number
	 * 
	 * @param n
	 *            Fibonacci number to be calculated
	 * @return The n-th Fibonacci number
	 */
	public static BigInteger fibonacciIter(int n) {
		BigInteger previous = new BigInteger("-1");
		BigInteger result = BigInteger.ONE;
		BigInteger sum;
		for (int i = 0; i <= n; i++) {
			sum = result.add(previous);
			previous = result;
			result = sum;
		}
		return result;
	}

	/**
	 * Recursive method of calculating the n-th Fibonacci number
	 * 
	 * @param n
	 *            Fibonacci number to be calculated
	 * @return The n-th Fibonacci number
	 */
	public static BigInteger fibonacciRec(int n) {
		if (n == 0) {
			return BigInteger.ZERO;
		} else if (n == 1) {
			return BigInteger.ONE;
		} else {
			return fibonacciRec(n - 2).add(fibonacciRec(n - 1));
		}
	}

	/**
	 * Recursive method to calculate the n-th Fibonacci number. Uses integers.
	 * 
	 * @param n
	 *            Fibonacci number to be calculated
	 * @return The n-th Fibonacci number
	 */
	public static int fibonacciInt(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacciInt(n - 1) + fibonacciInt(n - 2);
		}
	}

	/**
	 * Improved recursive method to find the n-th Fibonacci number. Uses an
	 * internal array to cache results and is much faster than the method above.
	 * 
	 * @param n
	 *            The Fibonacci number to be found
	 * @return Returns the n-th Fibonacci number
	 */
	public static BigInteger fibonacciMem(int n) {
		// Check cache
		if (cache[n] != null)
			return cache[n]; // Cache hit

		if (n == 0) {
			return BigInteger.ZERO;
		} else if (n == 1) {
			return BigInteger.ONE;
		} else {
			cache[n] = fibonacciMem(n - 2).add(fibonacciMem(n - 1));
			return cache[n];
		}
	}

	/**
	 * NOT YET IMPLEMENTED. Calculates the Fibonacci number using matrices. Uses
	 * an internal function to calculate the dot product of two matrices and
	 * compares them.
	 * 
	 * @param n -
	 * @return -
	 */
	public static BigInteger fibonacciMat(int n) {
		// BigInteger[] fib = { BigInteger.ONE, BigInteger.ONE, BigInteger.ONE,
		// BigInteger.ZERO };
		// TODO: Not yet implemented
		return BigInteger.ZERO;
	}

	// private static BigInteger[] dotP(BigInteger[] a, BigInteger[] b) {
	// return new BigInteger[] {
	// (a[0].multiply(b[0])).add(a[1].multiply(b[2])),
	// (a[0].multiply(b[1]).add(a[1].multiply(b[3]))),
	// (a[2].multiply(b[0])).add(a[3].multiply(b[2])),
	// (a[2].multiply(b[1])).add(a[3].multiply(b[3])) };
	// }

	/*
	 * F_n = 1/sqrt(5)(((1 + sqrt(5))/2)^n - ((1-sqrt(5))/2)^n)
	 */

	public static void main(String[] args) {
		MyTimer timer = new MyTimer();
		System.out.println("Recursive");

		for (int i = 0; i <= 40; i++) {
			timer.resetTimer();
			timer.startTimer();
			System.out.println(i + ": " + fibonacciRec(i) + ", " + timer);
		}

		System.out.println("Recursive with caching");
		for (int i = 0; i <= 40; i++) {
			timer.resetTimer();
			timer.startTimer();
			System.out.println(i + ": " + fibonacciMem(i) + ", " + timer);
		}

		System.out.println("Fibonacci with matrices");
		
		// TODO: fibonacciMat()
	}
}