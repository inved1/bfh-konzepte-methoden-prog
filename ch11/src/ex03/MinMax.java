package ex03;

import java.util.Random;

/**
 * Class to calculate the minimum and maximum value in an array. The class
 * contains methods to do this recursively as well as in an iterative way.
 * 
 * @author simon
 * @since 13.03.2012
 * 
 */
class MinMax {

	/**
	 * Total compares
	 */
	static private int compares = 0;

	/**
	 * Total recursive calls
	 */
	static private int recursiveCalls = 0;

	/**
	 * Iterative way to calculate the minimum and maximum value in an array
	 * 
	 * @param a
	 *            The array that will be searched through
	 * @return An integer array with two values: index 0 contains the minimum
	 *         value, index 1 contains the maximum value
	 */
	static private int[] minMax(int a[]) {
		int res[] = new int[2];
		res[0] = a[0];
		res[1] = a[0];
		for (int i = 1; i < a.length; i++) {
			++compares;
			if (a[i] > res[1]) {
				res[1] = a[i];
			} else {
				++compares;
				if (a[i] < res[0]) {
					res[0] = a[i];
				}
			}
		}
		return res;
	}

	/**
	 * Method for recursive search of the minimum and maximum value of the
	 * array. Divide and conquer method
	 * 
	 * @param a
	 *            The array that will be searched through
	 * @param left
	 *            Left boundary
	 * @param right
	 *            Right boundary
	 * @return An integer array with two values: index 0 contains the minimum
	 *         value, index 1 contains the maximum value
	 */
	static private int[] minMaxRec(int a[], int left, int right) {
		recursiveCalls++;
		if ((right - left) <= 1) {
			compares++;
			if (a[left] > a[right]) {
				return new int[] { a[right], a[left] };
			} else {
				return new int[] { a[left], a[right] };
			}
		} else {
			int middle = (right + left) / 2;
			// Right half of the slice (+1 to avoid overlapping element)
			int[] r = minMaxRec(a, middle + 1, right);
			// Left half of the slice
			int[] l = minMaxRec(a, left, middle);

			// Look for the smaller of the two
			int min = r[0] < l[0] ? r[0] : l[0];

			// Look for the larger of the two
			int max = r[1] > l[1] ? r[1] : l[1];
			compares += 2;

			return new int[] { min, max };
		}
	}

	static public void main(String args[]) {
		int anz;
		int a[];
		int res[];
		Random r = new Random();

		// Fill array with random values
		try {
			anz = Integer.parseInt(args[0]);
		} catch (Exception e) {
			anz = 128;
		}
		a = new int[anz];
		for (int i = 0; i < anz; i++) {
			a[i] = (int) (r.nextInt(20 * anz));
		}

		System.out.println("Number of elements in array = " + anz);

		compares = 0;
		res = minMax(a);
		System.out.println("ITERATIVE: minimum=" + res[0] + ", maximum="
				+ res[1] + ", compares=" + compares);

		compares = 0;
		res = minMaxRec(a, 0, a.length - 1);
		// Compares will be around V(n) = 3/2*n - 2
		System.out.println("REKURSIVE: minimum=" + res[0] + ", maximum="
				+ res[1] + ", compares=" + compares + ", calls="
				+ recursiveCalls);
	}
}