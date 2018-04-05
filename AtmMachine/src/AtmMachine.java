/*
 * Filename: AtmMachine.java
 * Author: Stephen Makowski
 * Date: April 8, 2018
 * Purpose: View/View Initializer for AtmMachine Program
 */

import java.awt.*;
import javax.swing.*;

public class AtmMachine extends JFrame{
	// constructor to create GUI
	private JButton withdrawButton, depositButton, transferButton, balanceButton;
	private JRadioButton checkingRadio, savingsRadio;
	private JTextField amountField;
	
	public AtmMachine() {
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
	   
        // set components as visible
        setVisible(true);
	}
	
	public static void main(String[] args) {
		// instantiate account objects and withdrawal tracker
		Account checking = new Account();
		Account savings = new Account();
		int withdrawlCount = 0;
		// Initialize GUI
		AtmMachine gui = new AtmMachine();
	}

}
