package ex01;

/**
 * Class to represent an ID card.
 * 
 * @author simon
 * 
 */
public class IDCard extends Card {

	/**
	 * ID of this card
	 */
	private String idNumber;

	/**
	 * Method to get the ID number of the card
	 * 
	 * @return The ID number of the card
	 */
	public String getIdNumber() {
		return idNumber;
	}

	/**
	 * Constructor for the class, takes the name of the card holder and the ID
	 * of this ID card as arguments
	 * 
	 * @param name
	 *            Card holder
	 * @param id
	 *            ID of this ID card
	 */
	public IDCard(String name, String id) {
		super(name);
		this.idNumber = id;
	}

	/**
	 * Method to get a formatted string for the card.
	 */
	public String format() {
		return super.format() + ", id=" + idNumber;
	}
}
