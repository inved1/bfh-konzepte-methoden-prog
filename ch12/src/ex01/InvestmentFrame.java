package ex01;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * Frame that represents a view for a BankAccount model with elements for
 * withdrawing cash, depositing cash and adding interest to the account.
 * 
 * @author simon
 * 
 */
public class InvestmentFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	/**
	 * Width of the frame
	 */
	private static final int FRAME_WIDTH = 600;

	/**
	 * Height of the frame
	 */
	private static final int FRAME_HEIGHT = 200;

	/**
	 * Default interest rate
	 */
	private static final double DEFAULT_RATE = 5;

	/**
	 * Initial balance displayed
	 */
	private static final double INITIAL_BALANCE = 1000;

	/**
	 * Interest GUI group
	 */
	private JLabel interestRateLabel;
	private JTextField interestRateField;
	private JButton interestRateButton;

	/**
	 * Withdraw GUI group
	 */
	private JLabel withdrawLabel;
	private JTextField withdrawField;
	private JButton withdrawButton;

	/**
	 * Deposit GUI group
	 */
	private JLabel depositLabel;
	private JTextField depositField;
	private JButton depositButton;

	/**
	 * Result label
	 */
	private JLabel resultLabel;

	/**
	 * Global panel that is used to arrange the elements
	 */
	private JPanel panel;

	/**
	 * Model that is used
	 */
	private BankAccount account;

	public InvestmentFrame(String title) {
		super(title);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		account = new BankAccount(INITIAL_BALANCE);

		// Use instance variables for components
		resultLabel = new JLabel("balance: " + account.getBalance());

		// Use helper methods
		createInterestRateText();
		createInterestButton();

		createWithdrawText();
		createWithdrawButton();

		createDepositText();
		createDepositButton();

		createPanel();

		setSize(FRAME_WIDTH, FRAME_HEIGHT);
		setVisible(true);
	}

	private void createDepositButton() {
		depositButton = new JButton("Deposit");

		class DepositListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				double amount = Double.parseDouble(depositField.getText());
				account.deposit(amount);
				updateResultLabel();
			}
		}

		ActionListener listener = new DepositListener();
		depositButton.addActionListener(listener);
	}

	private void createDepositText() {
		depositLabel = new JLabel("Deposit: ");
		depositField = new JTextField();
	}

	private void createWithdrawButton() {
		withdrawButton = new JButton("Withdraw");

		class WithdrawListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				double amount = Double.parseDouble(withdrawField.getText());
				account.withdraw(amount);
				updateResultLabel();
			}
		}

		ActionListener listener = new WithdrawListener();
		withdrawButton.addActionListener(listener);
	}

	private void createWithdrawText() {
		withdrawLabel = new JLabel("Withdraw: ");
		withdrawField = new JTextField();
	}

	private void createInterestRateText() {
		interestRateLabel = new JLabel("Interest Rate: ");
		interestRateField = new JTextField();

		interestRateField.setText("" + DEFAULT_RATE);
	}

	private void createInterestButton() {
		interestRateButton = new JButton("Add Interest");

		class AddInterestListener implements ActionListener {
			public void actionPerformed(ActionEvent event) {
				double rate = Double.parseDouble(interestRateField.getText());
				account.addInterest(rate);
				updateResultLabel();
			}
		}

		ActionListener listener = new AddInterestListener();
		interestRateButton.addActionListener(listener);
	}

	/**
	 * Update the resultLabel with the new balance of the account.
	 */
	private void updateResultLabel() {
		resultLabel.setText("balance: " + account.getBalance());
	}

	private void createPanel() {
		panel = new JPanel();
		panel.setLayout(new GridLayout(0, 3));
		panel.add(interestRateLabel);
		panel.add(interestRateField);
		panel.add(interestRateButton);

		panel.add(depositLabel);
		panel.add(depositField);
		panel.add(depositButton);

		panel.add(withdrawLabel);
		panel.add(withdrawField);
		panel.add(withdrawButton);

		panel.add(resultLabel);
		add(panel);
	}
}
