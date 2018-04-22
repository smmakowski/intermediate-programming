/*
 * Filename: Project3Gui.java
 * Author: Stephen Makowski
 * Date: April 22, 2018
 * Purpose: Project 3 GUI and file writer
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project3Gui extends JFrame {
	private JRadioButton iterativeRadio, recursiveRadio;
	private JLabel nLabel, resultLabel, efficiencyLabel;
	private JTextField nField, resultField, efficiencyField;
	private JButton computeButton;
	
	public Project3Gui() {
		// create window and set gridbag for main panel
		setTitle("Project 3");
		setSize(375, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
		
	    JPanel mainPanel = new JPanel(new GridBagLayout());
	    getContentPane().add(mainPanel);
	    GridBagConstraints gb = new GridBagConstraints();
	    
	    // add components
	    iterativeRadio = new JRadioButton("Iterative", true);
	    gb.gridx = 1;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(iterativeRadio, gb);
        
	    recursiveRadio = new JRadioButton("Recursive");
	    gb.gridx = 1;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(recursiveRadio, gb);
        
        ButtonGroup radioGroup = new ButtonGroup(); // add radio buttons to group
        radioGroup.add(iterativeRadio);
        radioGroup.add(recursiveRadio);
        
        nLabel = new JLabel("Enter n:");
	    gb.gridx = 0;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(nLabel, gb);
        
        nField = new JTextField("");
	    gb.gridx = 1;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(nField, gb);
        
        computeButton = new JButton("Compute");
	    gb.gridx = 1;
        gb.gridy = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(computeButton, gb);
        
        
        resultLabel = new JLabel("Result:");
	    gb.gridx = 0;
        gb.gridy = 4;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(resultLabel, gb);
        
        resultField = new JTextField("");
	    gb.gridx = 1;
        gb.gridy = 4;
        gb.fill = GridBagConstraints.HORIZONTAL;
        resultField.setEditable(false); // prevent user from editign field
        mainPanel.add(resultField, gb);
        
        efficiencyLabel = new JLabel("Efficiency:");
	    gb.gridx = 0;
        gb.gridy = 5;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(efficiencyLabel, gb);
        
        efficiencyField = new JTextField("");
	    gb.gridx = 1;
        gb.gridy = 5;
        gb.fill = GridBagConstraints.HORIZONTAL;
        efficiencyField.setEditable(false); // prevent editable by user
        mainPanel.add(efficiencyField, gb);
        
        // add listener for computer button
        computeButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e) throws NumberFormatException {
            	// try to calculate and set fields appropriately
        	    try {
        	    	int n = Integer.parseInt(nField.getText()); // parse input
        	    	if (n < 0) { // notify user if input not valid
        	    		JOptionPane.showMessageDialog(null, "Value entered for 'n' is not a valid number.\nPlease make sure that n is an integer\ngreater than or equal to 0.", 
        	        	"Invalid Number", JOptionPane.PLAIN_MESSAGE);
        	    		resultField.setText("");
        	    		efficiencyField.setText("");
        	    	} else {
        	    		int result = 0; // set result to 0
        	    		if (iterativeRadio.isSelected()) { // run interative if checked
        	    			result = Sequence.computeIterative(n);
        	    		} else { // else recursive
        	    			result = Sequence.computeRecursive(n);
        	    		}
        	    		// set fields
        	    		resultField.setText(Integer.toString(result));
        	    		efficiencyField.setText(Integer.toString(Sequence.getEfficiency()));
        	    	}
        	    } catch (NumberFormatException ex) { // notify user if input not parseable
        	    	JOptionPane.showMessageDialog(null, "Value entered for 'n' is not a valid number.\nPlease make sure that n is an integer\ngreater than or equal to 0.", 
        	    	"Invalid Number", JOptionPane.PLAIN_MESSAGE);
    	    		resultField.setText("");
    	    		efficiencyField.setText("");
        	    }
            }
        });
        
        // set visible
        setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project3Gui gui = new Project3Gui();
	}

}
