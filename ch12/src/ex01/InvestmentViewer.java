package ex01;

import javax.swing.SwingUtilities;

/**
 * This program displays the growth of an investment.
 */
public class InvestmentViewer {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				new InvestmentFrame("Investment Calculator");
			}
		});
	}
}
