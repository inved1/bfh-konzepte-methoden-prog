package ex02;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

/**
 * Small class to spell check a file with the basic UNIX dictionary
 * (/usr/share/dict/words).
 * 
 * @author simon
 * @since 22.02.2012
 * 
 */
public class SpellChecker {

	/**
	 * Dictionary to be used
	 */
	private static final String DICT_LOCATION = "/usr/share/dict/words";

	/**
	 * HashSet containing all words in the dictionary
	 */
	private static HashSet<String> dictionary = new HashSet<String>();

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {

		/**
		 * Build dictionary
		 */
		Scanner dictscanner = new Scanner(new File(DICT_LOCATION));
		while (dictscanner.hasNext()) {
			dictionary.add(dictscanner.next());
		}
		dictscanner.close();
		System.out.println(dictionary.size() + " words loaded from dictionary "
				+ DICT_LOCATION);

		/**
		 * Check file
		 */
		if (args.length == 1) {
			String checkfile = args[0];
			File infile = new File(checkfile);
			Scanner fscan = new Scanner(infile);

			System.out.println("Spellcheck of \"" + checkfile + "\":");
			
			// For sanitation
			fscan.useDelimiter("[A-Za-z]+");
			while (fscan.hasNext()) {
				String word = fscan.next();
				if (!dictionary.contains(word)) {
					System.out.println("Word \"" + word + "\" not found.");
				}
			}
			fscan.close();

		} else {
			System.err.println("Wrong number of arguments: " + args.length);
			System.out.println("Usage: SpellChecker <input>");
		}
	}

}
