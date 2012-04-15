package ex05;

import java.util.ArrayList;

/**
 * Class to generate all substrings from a given string. This class features a
 * static method to recursively get all substrings from a given string.
 * 
 * @author simon
 * 
 */
public class SubstringGenerator {

	/**
	 * Method to recursively get all substrings from a string
	 * 
	 * @param fullstr
	 *            The full string that will be searched for substrings
	 * @return An ArrayList containing all substrings found
	 */
	public static ArrayList<String> substrings(String fullstr) {

		ArrayList<String> result = new ArrayList<String>();

		if (fullstr.length() <= 0) {
			// Empty string
			result.add(fullstr);
			return result;
		} else {
			// Remove first character and resursively call substrings() again
			ArrayList<String> newRes = substrings(fullstr.substring(1));
			for (String s : newRes) {
				result.add(s);
			}

			// Add all strings that start with fullstr[0]
			for (int i = 1; i <= fullstr.length(); i++) {
				result.add(fullstr.substring(0, i));
			}

			return result;
		}
	}
}
