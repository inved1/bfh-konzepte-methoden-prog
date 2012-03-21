package ex03;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to replace tabs by whitespaces.
 * @author simon
 * @since 28.02.2012
 *
 */
public class TabExpander {

	/**
	 * Default tab width if no tabwidth is specified
	 */
	private static final int DEFAULT_TABWIDTH = 4;

	/**
	 * Variable to hold the actual tab width that will be used
	 */
	private static int tabWidth;

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		tabWidth = DEFAULT_TABWIDTH;
		String filename = "";

		if (args.length == 1 || args.length == 3) {
			if (args.length == 3) {
				if (args[0].equals("-t")) {
					tabWidth = Integer.parseInt(args[1]);
					filename = args[2];
				} else {
					System.err.println("Unknown argument: " + args[0]);
					usage();
				}
			} else {
				filename = args[0];
			}

			File infile = new File(filename);
			Scanner in = new Scanner(infile);

			while (in.hasNextLine()) {
				expandLine(in.nextLine());
			}
			in.close();
		} else {
			System.err.println("Wrong number of arguments: " + args.length);
			usage();
		}
	}

	/**
	 * Method to expand one tab line. Inspired by Christian Meyer, thanks!
	 * 
	 * @param line Line where tabs will be replaced
	 */
	private static void expandLine(String line) {
		for (int i = 0; i < line.length(); i++) {
			if (line.charAt(i) == '\t') {
				// Ah, we need to do something

				// First, create the replacement
				char[] replacement = new char[tabWidth - (i % tabWidth)];
				for (int spaces = 0; spaces < replacement.length; spaces++) {
					replacement[spaces] = ' ';
				}

				// Then, do the actual replacement
				String replacementString = new String(replacement);
				line = line.replaceFirst("\\t", replacementString);
			}
		}
		System.out.println(line);
	}

	/**
	 * Prints usage
	 */
	private static void usage() {
		System.out.println("Usage: TabExpander [-t] filename");
		System.out
				.println("Example: \"TabExpander -t 4 filename\" or \"TabExpander filename\"");
		System.out.println("Options:");
		System.out.println("-t: <tabwidth>");
	}

}
