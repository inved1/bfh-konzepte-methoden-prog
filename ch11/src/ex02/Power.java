package ex02;

import java.math.BigInteger;

import misc.MyTimer;

/**
 * Class to calculate the power of a number, using recursion
 * 
 * @author simon
 * @since 13.03.2012
 * 
 */
public class Power {

	/**
	 * Internal variable for analysis of performance. Counts number of recursive
	 * calls for the "normal" version of the algorithm.
	 */
	static long powerCount = 0;

	/**
	 * Internal variable for analysis of performance. Counts number of recursive
	 * calls for the fast implementation of the algorithm.
	 */
	static long fastPowerCount = 0;

	/**
	 * Default algorithm to calculate the power of a value (x^n)
	 * 
	 * @param x
	 * @param n
	 * @return x^n
	 */
	static public BigInteger power(BigInteger x, long n) {
		powerCount++;
		if (n == 0) {
			return BigInteger.ONE;
		} else if (n == 1) {
			return x;
		}
		return x.multiply(power(x, n - 1));
	}

	/**
	 * Improved fast algorithm to calculate the power of a value (x^n). Number of recursive calls is log_2(n)
	 * 
	 * @param x
	 * @param n
	 * @return x^n
	 */
	static public BigInteger fastPower(BigInteger x, long n) {
		fastPowerCount++;
		if (n == 0) {
			return BigInteger.ONE;
		} else if (n == 1) {
			return x;
		}
		// When n is even, use (x^2)^(n/2)
		// When n is odd, use (x^2)^((n-1)/2)
		return n % 2 == 0 ? fastPower(x.multiply(x), n / 2) : fastPower(
				x.multiply(x), (n - 1) / 2).multiply(x);
	}

	public static void main(String s[]) {
		MyTimer timer = new MyTimer();
		timer.startTimer();

		// Use default algorithm
		for (long i = 0; i <= 3000; i++) {
			power(new BigInteger("5"), i);
		}
		timer.stopTimer();
		System.out.println("Rekursive with power(): " + timer + ", count: " + powerCount);

		timer.resetTimer();
		timer.startTimer();

		for (long i = 0; i <= 3000; i++) {
			fastPower(new BigInteger("5"), i);
		}

		timer.stopTimer();
		System.out.println("fastPower(): " + timer + ", count: "
				+ fastPowerCount + " [should be log_2(n)]");

		// Correctness check (courtesy of Christoph Seiler):
		for (long i = 0; i <= 3000; i++) {
			BigInteger a = power(new BigInteger("5"), i);
			BigInteger b = fastPower(new BigInteger("5"), i);

			if (!a.equals(b)) {
				System.out.println(i + " :: " + a.toString() + " : "
						+ b.toString());
			}
		}
	}
}
