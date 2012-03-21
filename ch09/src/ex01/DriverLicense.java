package ex01;

/**
 * Class to represents a drivers license.
 * 
 * @author simon
 * @since 04.03.2012
 * 
 */
public class DriverLicense extends IDCard {

	/**
	 * Expiration year
	 */
	private int expYear;

	/**
	 * Method to get the expiration year
	 * 
	 * @return The expiration year of the drivers license
	 */
	public int getExpYear() {
		return expYear;
	}

	/**
	 * Constructs a new drivers license
	 * 
	 * @param name
	 *            Name of the holder
	 * @param id
	 *            ID of the drivers license
	 * @param expirationYear
	 *            Expiration year of the license
	 */
	public DriverLicense(String name, String id, int expirationYear) {
		super(name, id);
		this.expYear = expirationYear;
	}

	/**
	 * Method to get a formatted string for the license.
	 */
	public String format() {
		return super.format() + ", expYear=" + expYear;
	}
}
