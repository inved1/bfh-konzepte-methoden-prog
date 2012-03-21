/**
 * 
 */
package ex04;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * @author simon
 * @since 28.02.2012
 * 
 *        Program to read floating point numbers from the user
 */
public class FloatingPointReader {

	/**
	 * ArrayList to hold all numbers we want to read
	 */
	private static ArrayList<Float> numbers = new ArrayList<Float>();

	/**
	 * Keep count of errors
	 */
	private static int tries = 0;

	/**
	 * Maximum number of tries
	 */
	private static final int MAX_TRIES = 2;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Floating Point Numbers");

		Scanner in = new Scanner(System.in);
		while (tries < MAX_TRIES) {
			try {
				System.out.print("Please enter a floating point number: ");
				float input = in.nextFloat();
				System.out.println("Input OK");
				numbers.add(input);
			} catch (InputMismatchException ex) {
				tries++;
				System.err.println("Input was no float: \'" + in.nextLine()
						+ "\'. You have " + (MAX_TRIES - tries)
						+ " tries left.");
			} catch (Exception ex) {
				tries++;
				System.err.println("Something else went wrong, input was "
						+ in.nextLine());
				ex.printStackTrace();
			}
		}

	}
}
