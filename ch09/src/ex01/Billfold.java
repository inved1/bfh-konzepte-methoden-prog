package ex01;

/**
 * Class to represent a billfold class to hold two cards. Features methods to
 * add cards and format cards.
 * 
 * @author simon
 * @since 04.03.2012
 * 
 */
public class Billfold {
	/**
	 * First card in the billfold
	 */
	private Card card1 = null;

	/**
	 * Second card in the billfold
	 */
	private Card card2 = null;

	/**
	 * Constructor for the class
	 */
	public Billfold() {

	}

	/**
	 * Method to add a card to the billfold. The billfold takes two cards in
	 * total.
	 * 
	 * @param c
	 *            The card that will be added to the billfold
	 */
	public void addCard(Card c) {
		if (card1 == null) {
			card1 = c;
		} else if (card2 == null) {
			card2 = c;
		}
	}

	/**
	 * Method to get a description of all cards in the billfold.
	 * 
	 * @return A string that describes the content of the billfold
	 */
	public String formatCards() {
		return "[" + card1.format() + "; " + card2.format() + "]";
	}
}
