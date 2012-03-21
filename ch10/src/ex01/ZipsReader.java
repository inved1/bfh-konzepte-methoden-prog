package ex01;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class ZipsReader {

	/**
	 * Input file
	 */
	private static final String INPUT_FILENAME = "src/ex01/ziptable.txt";

	/**
	 * Output file
	 */
	private static final String OUTPUT_FILENAME = "src/ex01/output.txt";

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		System.out.println("Program start");

		File ziptable = new File(INPUT_FILENAME);
		Scanner in = new Scanner(ziptable);

		File outputFile = new File(OUTPUT_FILENAME);
		PrintWriter out = new PrintWriter(outputFile);

		while (in.hasNextLine()) {
			String line = in.nextLine();
			Scanner lscanner = new Scanner(line);

			// Get the state abbreviation
			String stateAbbr = lscanner.next("[A-Z]{2}");

			// Get the state name
			String stateName = "";
			while (lscanner.hasNext("[^0-9]*")) {
				stateName += " " + lscanner.next();
				stateName = stateName.trim();
			}

			/**
			 *  Read the zip codes
			 */
			ArrayList<String> zipCodes = new ArrayList<String>();
			while (lscanner.hasNext()) {
				String token = lscanner.next();
				if (token.matches("\\d{3}-\\d{3}")) {
					zipCodes.add(token);
				} else if (token.matches("\\d{3}")) {
					zipCodes.add(token + "-" + token);
				}
			}

			/**
			 * Write the clean entry
			 */
			out.print(stateAbbr + " " + stateName);
			for (String zip : zipCodes) {
				out.print(" " + zip);
			}
			out.println();
		}
		out.close();
		in.close();

		System.out.println("Done.");
	}

}
