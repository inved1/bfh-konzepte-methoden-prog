package ex01;

/**
 * Class to represent a card. This class is used as a superclass for other
 * classes.
 * 
 * @author simon
 * @since 04.03.2012
 * 
 */
public class Card {

	/**
	 * Name of the card holder
	 */
	private String name;

	/**
	 * Constructor for the class without an argument. Name is set to ""
	 */
	public Card() {
		name = "";
	}

	/**
	 * Constructor for the class, takes the name of the card holder as an
	 * argument.
	 * 
	 * @param n
	 *            Name of the card holder
	 */
	public Card(String n) {
		name = n;
	}

	/**
	 * Method to get the name of the card holder
	 * @return The name on the card
	 */
	public String getName() {
		return name;
	}

	/**
	 * UNIMPLEMENTED
	 * @return
	 */
	public boolean isExpired() {
		return false;
	}

	/**
	 * Method to get a formatted string for the card.
	 */
	public String format() {
		return "name=" + name;
	}
}