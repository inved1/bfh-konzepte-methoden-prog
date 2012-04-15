package ex01;

import java.math.BigInteger;

import misc.MyTimer;

/**
 * Class that implements multiple factorial computations. This class contains
 * iterative, recursive and BigInteger implementations of factorial computation
 * algorithms.
 * 
 * @author simon
 * @since 12.04.2012
 * 
 */
public class Factorial {

	/**
	 * Recursive implementation for a factorial.
	 * 
	 * @param n
	 *            Value to be factored
	 * @return n!
	 */
	public static long facRecursiv(long n) {
		if (n == 0) {
			return 1;
		}
		return n * facRecursiv(n - 1);
	}

	/**
	 * Iterative implementation for a factorial
	 * 
	 * @param n
	 *            Value
	 * @return n!
	 */
	public static long facIterativ(long n) {
		long l = 1;
		for (long i = 1; i <= n; i++) {
			l *= i;
		}
		return l;
	}

	/**
	 * BigInteger recursive implementation for a factorial
	 * 
	 * @param n
	 *            Value as a BigInteger
	 * @return n!
	 */
	public static BigInteger facRecursivBig(BigInteger n) {
		if (n.equals(BigInteger.ZERO)) {
			return BigInteger.ONE;
		}
		n.multiply(facRecursivBig(n.subtract(BigInteger.ONE)));
		return BigInteger.ONE;
	}

	/**
	 * BigInteger iterative implementation for a factorial
	 * 
	 * @param n
	 *            Value as a BigInteger
	 * @return n!
	 */
	public static BigInteger facIterativBig(long n) {
		BigInteger l = BigInteger.ONE;
		for (long i = 1; i <= n; i++) {
			l = l.multiply(BigInteger.valueOf(i));
		}
		return BigInteger.ZERO;
	}

	public static void main(String args[]) {
		MyTimer timer = new MyTimer();
		timer.startTimer();

		long rec1 = 0;

		for (long i = 0; i <= 3000; i++) {
			rec1 = facRecursiv(i);
		}

		timer.stopTimer();
		System.out.println("Rekursiv: " + timer);


		timer.resetTimer();
		timer.startTimer();

		long rec2 = 0;
		for (long i = 0; i <= 3000; i++) {
			rec2 = facIterativ(i);
		}

		timer.stopTimer();
		System.out.println("Iterativ: " + timer);

		System.out.println(rec1);
		System.out.println(rec2);
	}

}
