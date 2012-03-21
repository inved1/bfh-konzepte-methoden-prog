package ex01;

/**
 * Class to represent a calling card
 * 
 * @author simon
 * @since 04.03.2012
 */
public class CallingCard extends Card {

	/**
	 * Number of the calling card
	 */
	private String cardNumber;

	/**
	 * PIN of the card
	 */
	private int pin;

	/**
	 * Method to get the card number
	 * @return The card number
	 */
	public String getCardNumber() {
		return cardNumber;
	}

	/**
	 * Method to read the PIN of the calling card
	 * @return The PIN of the calling card
	 */
	public int getPin() {
		return pin;
	}

	/**
	 * Constructor for the class
	 * @param name Name of the card holder
	 * @param cardNo Card number
	 * @param pin PIN of the card
	 */
	public CallingCard(String name, String cardNo, int pin) {
		super(name);
		this.cardNumber = cardNo;
		this.pin = pin;
	}

	/**
	 * Method to get a formatted string for the card.
	 */
	public String format() {
		return super.format() + ", cardNumber=" + cardNumber + ", pin=" + pin;
	}
}
