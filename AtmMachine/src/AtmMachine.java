/*
 * Filename: AtmMachine.java
 * Author: Stephen Makowski
 * Date: April 8, 2018
 * Purpose: View/View Initializer for AtmMachine Program
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class AtmMachine extends JFrame{
	// GUI component fields
	private JButton withdrawButton, depositButton, transferButton, balanceButton;
	private JRadioButton checkingRadio, savingsRadio;
	private JTextField amountField;
	// fields for accounts
	private static Account activeAccount;
	private static Account checking;
	private static Account savings;
	
	public AtmMachine() {
		/*
		 * THE FOLLOW CODE SETS OF THE USER INTERFACE GRID LAYOUT SIZES AND LABELS
		 */
		
		setTitle("ATM Machine");
		setSize(400, 225);
		// setMinimumSize(new Dimension(400, 225)); TODO Set minum and Max sizes during final styling
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
	    // create main panel and to window, create GridBagCosntraints
        JPanel mainPanel = new JPanel(new GridBagLayout()); // create JPanel with GridBagLayout
        getContentPane().add(mainPanel); // add panel to window
        GridBagConstraints gb = new GridBagConstraints(); // create Constraings obj
        
        // Create Buttons and set location, contains and style
        withdrawButton = new JButton("Withdraw"); // create button
        gb.gridx = 0; // set X location on grid
        gb.gridy = 0; // set Y location on grid
        gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
        mainPanel.add(withdrawButton, gb); // add to panel
        
        depositButton = new JButton("Deposit");
        gb.gridx = 1;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(depositButton, gb);
        
        transferButton = new JButton("Transfer");
        gb.gridx = 0;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(transferButton, gb);
        
        balanceButton = new JButton("Balance");
        gb.gridx = 1;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(balanceButton, gb);
        
        // create and add Radio Buttons
        checkingRadio = new JRadioButton("Checking", true); // instantiate new RadioButton that is selected
        gb.gridx = 0;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(checkingRadio, gb);
//        checkingRadio.setMnemonic(KeyEvent.VK_R);
//        checking.setActionCommand(rabbitString);

        savingsRadio = new JRadioButton("Savings");
        gb.gridx = 1;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(savingsRadio, gb);
//        pigButton.setMnemonic(KeyEvent.VK_P);
//        pigButton.setActionCommand(pigString);

        // Group the radio buttons.
        ButtonGroup radioGroup = new ButtonGroup();
        radioGroup.add(checkingRadio);
        radioGroup.add(savingsRadio);
        
        // create and add text field for amounts input
        amountField = new JTextField("");
        gb.gridx = 0;
        gb.gridy = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        gb.gridwidth = 2; // allow field to take of two cells in a row on layout
        mainPanel.add(amountField, gb);
	   
        /*
         * THE FOLLOWING CODE ADDS ACTION LISTENERS TO BUTTONS AND RADIOBUTTONS
         */
        
       // add Action listeners to buttons
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

            }
        });
       
        depositButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) throws NumberFormatException {
        		try {
        			double deposit =  Double.parseDouble(amountField.getText());
        			System.out.println("Valid Deposit");
        			if (deposit <= 0.0) {
        				JOptionPane.showMessageDialog(null, "Error: '" + amountField.getText() + 
        	        	"' is not a number. Please Enter a valid Dollar Amount", "Not a Number", 
        	        	JOptionPane.ERROR_MESSAGE);
        			}
        		} catch (NumberFormatException ex) {
        			JOptionPane.showMessageDialog(null, "Error: '" + amountField.getText() + 
        			"' is not a number. Please Enter a valid Dollar Amount", "Not a Number", 
        			JOptionPane.ERROR_MESSAGE);
        		}
           }
        });
       
        transferButton.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        
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
	
	// main methods creates Account Instances and inits GUI
	public static void main(String[] args) {
		// instantiate account objects and withdrawal tracker
		checking = new Account("Checking");
		savings = new Account("Savings");
		activeAccount = checking; // set active account as checking (since radio button is checking by default)
		int withdrawlCount = 0;
		// Initialize GUI
		AtmMachine gui = new AtmMachine();
	}

}
