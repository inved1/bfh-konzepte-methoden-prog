package ex01;

/**
 * Class to test the Billfold class and all associated card classes.
 * 
 * @author simon
 * @since 04.03.2012
 * 
 */
public class BillfoldTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Billfold b = new Billfold();

		DriverLicense dl = new DriverLicense("John Smith", "1234", 2019);
		IDCard ic = new IDCard("Jane Doe", "4321");

		b.addCard(dl);
		b.addCard(ic);

		System.out.println(b.formatCards());

	}

}
