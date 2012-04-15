package ex05;

import java.util.ArrayList;

/**
 * Tester class for substrings
 * 
 * @author simon
 * 
 */
public class SubstringTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String testString = "abcd";

		ArrayList<String> result = SubstringGenerator.substrings(testString);
		System.out.println(result);

	}

}
