

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.PrintWriter;
import java.util.Scanner;

public class LineNumberer {

	public static void main(String[] args) throws FileNotFoundException {
		
		Scanner console = new Scanner(System.in);
		System.out.print("Input file: ");
		String inputfile = console.nextLine();
		System.out.print("Output file: ");
		String outputfile = console.nextLine();
		
		FileReader input = new FileReader(inputfile);
		Scanner in = new Scanner(input);
		
		PrintWriter out = new PrintWriter(outputfile);
		
		int lineNumber = 1;
		
		while(in.hasNextLine()) {
			String line = in.nextLine();
			out.println("/* " + lineNumber + " */ " + line);
			lineNumber++;
		}
		
		in.close();
		out.close();
	}
	
	// next = bis zum nächsten whitespace (incl. \t, \n, \r, [ ])
	// 
	
}
