/*
 * Filename: AtmMachine.java
 * Author: Stephen Makowski
 * Date: April 8, 2018
 * Purpose: View/View Initializer for AtmMachine Program
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AtmMachine extends JFrame {
	// GUI component fields
	private static JPanel mainPanel;
	private JButton withdrawButton, depositButton, transferButton, balanceButton;
	private JRadioButton checkingRadio, savingsRadio;
	private static JTextField amountField;
	private static GridBagConstraints gb;
	// fields for accounts
	private static Account activeAccount;
	private static Account checking;
	private static Account savings;
	
	public AtmMachine() {
		/*
		 * THE FOLLOW CODE SETS OF THE USER INTERFACE GRID LAYOUT SIZES AND LABELS
		 */
		
		setTitle("ATM Machine");
		setSize(375, 250);
		setMinimumSize(new Dimension(300, 200)); // TODO Set minum and Max sizes during final styling
		setMaximumSize(new Dimension(450, 300));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    // create main panel and to window, create GridBagCosntraints
        mainPanel = new JPanel(new GridBagLayout()); // create JPanel with GridBagLayout
        getContentPane().add(mainPanel); // add panel to window
        gb = new GridBagConstraints(); // create Constraings obj
        
        // Create Buttons and set location, contains and style
        withdrawButton = new JButton("Withdraw"); // create button
        setGridAndStyleFor(withdrawButton, 0, 0, 1);
        
        depositButton = new JButton("Deposit");
        setGridAndStyleFor(depositButton, 1, 0, 1);
        
        transferButton = new JButton("Transfer");
        setGridAndStyleFor(transferButton, 0, 1, 1);
        
        balanceButton = new JButton("Balance");
        setGridAndStyleFor(balanceButton, 1, 1, 1);
        
        // create and add Radio Buttons
        checkingRadio = new JRadioButton("Checking", true); // instantiate new RadioButton that is selected
        setGridAndStyleFor(checkingRadio, 0, 2, 1);

        savingsRadio = new JRadioButton("Savings");
        setGridAndStyleFor(savingsRadio, 1, 2, 1);

        // Group the radio buttons.
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(checkingRadio);
        radioGroup.add(savingsRadio);
        
        // create and add text field for amounts input
        amountField = new JTextField("");
        setGridAndStyleFor(amountField, 0, 3, 2);
        
        /*
         * THE FOLLOWING CODE ADDS ACTION LISTENERS TO BUTTONS AND RADIOBUTTONS
         */
        
       // add Action listeners to buttons
        withdrawButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) throws NumberFormatException {
	        	try {
	    			double withdrawal =  Double.parseDouble(amountField.getText());
	    			if (withdrawal <= 0.0) { // show OptionPane if invalid deposit amount
	    				amountNotPositiveMessage();
	        		} else { // deposit into account and notify user
	    				boolean serviceChargeAdded = activeAccount.withdraw(withdrawal);
	    				JOptionPane.showMessageDialog(null, "You have sucessfully withdrawn $" +
	    				withdrawal + " from your " + activeAccount.getName() + " account.\nYour " + activeAccount.getName() +
	    				" Account balance is now " + activeAccount.balance() + ".\n" +
	    				(serviceChargeAdded ? "A $1.50 service charged has been added\n for making 5 or more more withdrawls during this session.\n" : "") +
	    				"You have made " + Integer.toString(Account.getWithdrawalCount()) + " withdrawals today.", "Withdrawal Successful",
	    				//provides notification of withdrawl, new balance, service charge notification, and withdrawl count
	            	    JOptionPane.PLAIN_MESSAGE);
	    			}
	    		} catch (NumberFormatException ex) {
	    			notANumberMessage();
	    		} catch (IllegalArgumentException ex) {
	    			JOptionPane.showMessageDialog(null, "Error: Amount must be in multiples of $20.00 (ex. 20.00, 60.00 120.00, etc.)", "Incorrect Dollar Amount", 
	    	    			JOptionPane.ERROR_MESSAGE);
        		} catch (InsufficientFunds ex) {
	    			insufficientFundsMessage();
	        	} finally { // in either case
	    			amountField.setText(""); // set amount field blank
	    		}
        	}
        });
       
        depositButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) throws NumberFormatException {
        		try {
        			double deposit =  Double.parseDouble(amountField.getText());
        			if (deposit <= 0.0) { // show OptionPane if invalid deposit amount
        				amountNotPositiveMessage();
        			} else { // deposit into account and notify user
        				activeAccount.deposit(deposit);
        				JOptionPane.showMessageDialog(null, "You have sucessfully deposited $" +
        				deposit + " into your " + activeAccount.getName() + " account. Your " + activeAccount.getName() +
        				" Account balance is now " + activeAccount.balance() + ".", "Deposit Successful", 
                	        	JOptionPane.PLAIN_MESSAGE);
        			}
        		} catch (NumberFormatException exc) {
        			notANumberMessage();
        		} finally { // in either case
        			amountField.setText(""); // set amount field blank
        		}
           }
        });
       
        transferButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		try {
	    			double transfer =  Double.parseDouble(amountField.getText());
	    			if (transfer <= 0.0) { // show OptionPane if invalid deposit amount
	    				amountNotPositiveMessage();
	        		} else { // deposit into account and notify user
	        			if (activeAccount.getName().equals("Checking")) {
	        				activeAccount.transfer(transfer, savings);
	        			} else {
	        				activeAccount.transfer(transfer, checking);
	        			}
	    				JOptionPane.showMessageDialog(null, "You have sucessfully transferred $" +
	    				transfer + "\nfrom your " + activeAccount.getName() + " account\nto your " + (activeAccount.getName().equals("Checking") ? "Savings Account" : "Checking Account") +
	    				".\nYour balances are\n\nChecking: " + checking.balance() + "\nSavings: " + savings.balance() 
	    				, "Transfer Successful",
	    				//provides notification of transfer, new balances for both accounts
	            	    JOptionPane.PLAIN_MESSAGE);
	    			}
	    		} catch (NumberFormatException ex) {
	    			notANumberMessage();
        		} catch (InsufficientFunds ex) {
        			insufficientFundsMessage();
	        	} finally { // in either case
	    			amountField.setText(""); // set amount field blank
	    		}
            }
        });
        // listener opens OptionPane containing balance for currently selected account when clicked
        balanceButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		JOptionPane.showMessageDialog(null, "Current balance for '" + activeAccount.getName() +
        		"' account is:\n\n" + activeAccount.balance(), "Current Balance", JOptionPane.PLAIN_MESSAGE);
            }
        });
        // listener sets active account as checking when triggered
        checkingRadio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
        	    activeAccount = checking;
            }
        });
        // listener sets active account as savings when triggered 
        savingsRadio.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) {
        	    activeAccount = savings;
            }
        });
        
        // set components as visible
        setVisible(true);
	}
	
	/*
	 * The following methods modularize common printing error messages using jPanes during error handling
	 */
	private void amountNotPositiveMessage() {
		JOptionPane.showMessageDialog(null, "Error: amount '" + amountField.getText() + 
	    "' is less than or equal to zero. Please enter a positive number for transaction.", "Transaction Amount Zero or Negative Number", 
	    JOptionPane.ERROR_MESSAGE);
	}
	
	private void notANumberMessage() {
		JOptionPane.showMessageDialog(null, "Error: '" + amountField.getText() + 
		"' is not a number. Please Enter a valid number amount for transaction.", "Transaction Amount Not a Number", 
		JOptionPane.ERROR_MESSAGE);
	}
	
	private void insufficientFundsMessage() {
		JOptionPane.showMessageDialog(null, "Error: You do not have enough funds in your " + activeAccount.getName() + " to make this transaction. " +
		"Please add funds to your " + activeAccount.getName() + " account and try again.",
    	"Insufficient Funds", JOptionPane.ERROR_MESSAGE);
	}
	
	/*
	 *  The Following method factors out the GridBagLayout settings and font style into a method
	 */

	private static void setGridAndStyleFor(JComponent component, int x, int y, int width) {
		gb.gridx = x; // set X location on grid
        gb.gridy = y; // set Y location on grid
        gb.gridwidth = width;
        gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
        component.setFont(new Font("Serif", Font.PLAIN, 28));
        mainPanel.add(component, gb); // add to panel
	}
	
	// main methods creates Account Instances and inits GUI
	public static void main(String[] args) {
		// instantiate account objects and withdrawal tracker
		checking = new Account("Checking");
		savings = new Account("Savings");
		activeAccount = checking; // set active account as checking (since radio button is checking by default)

		// Initialize GUI
		AtmMachine gui = new AtmMachine();
	}
}
