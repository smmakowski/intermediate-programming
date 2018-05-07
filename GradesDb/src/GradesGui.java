/*
 * Filename: GradesGui.java
 * Author: Stephen Makowski
 * Date: May 6, 2018
 * Purpose: Gui and event listeners for project 4
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GradesGui extends JFrame {
	private JComboBox crudCombo, creditCombo, gradeCombo;
	private JLabel idLabel, nameLabel, majorLabel, crudLabel;
	private JTextField idField, nameField, majorField;
	private JButton processButton;
	private HashMap<String, Student> data = new HashMap<String, Student>();
	
	private boolean settingCredits = false;
	private boolean settingGrade = false;
	
	public GradesGui() {
		// set window paramters
		setTitle("Project 4");
		setSize(300, 200);
		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		
		// set main panel
		JPanel mainPanel = new JPanel(new GridBagLayout());
		getContentPane().add(mainPanel);
		GridBagConstraints gb = new GridBagConstraints();
		
		// labels and textfields
		JLabel idLabel = new JLabel("Id:");
		gb.gridx = 0;
		gb.gridy = 0;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(idLabel, gb);
		
		idField = new JTextField("");
		gb.gridx = 1;
		gb.gridy = 0;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(idField, gb);
		
		JLabel nameLabel = new JLabel("Name:");
		gb.gridx = 0;
		gb.gridy = 1;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(nameLabel, gb);
		
		nameField = new JTextField("");
		gb.gridx = 1;
		gb.gridy = 1;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(nameField, gb);
		
		JLabel majorLabel = new JLabel("Major:");
		gb.gridx = 0;
		gb.gridy = 2;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(majorLabel, gb);
		
		majorField = new JTextField("");
		gb.gridx = 1;
		gb.gridy = 2;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(majorField, gb);
		
		JLabel crudLabel = new JLabel("Choose Selection:");
		gb.gridx = 0;
		gb.gridy = 3;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(crudLabel, gb);
		
		// add comboBox
		String[] crudOptions = {
				"Insert",
				"Delete",
				"Find",
				"Update"
		};
		
		crudCombo = new JComboBox(crudOptions);
		crudCombo.setEditable(false);
		gb.gridx = 1;
		gb.gridy = 3;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(crudCombo, gb);
		
		// add processing button
		processButton = new JButton("Process Request");
		gb.gridx = 0;
		gb.gridy = 4;
		gb.fill = GridBagConstraints.HORIZONTAL;
		mainPanel.add(processButton, gb);
		
		processButton.addActionListener(processButtonListener);
		
		setVisible(true);
	}
	// listener for process button
	private ActionListener processButtonListener = new ActionListener () {
	    public void actionPerformed(ActionEvent event) {
	    	// get the value of 
	    	String selected = crudCombo.getSelectedItem().toString();
	    	if (selected.equals("Insert")) {
	    		insert();
	    	} else if (selected.equals("Delete")) {
	    		delete();
	    	} else if (selected.equals("Find")) {
	    		find();
	    	} else { // if 'update'
	    		update();
	    	}
	    }
	};
	
	// private methods for crud operations
	private void insert() {
		// if no value in ID field notify user of error
		if (idField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
			"No ID entered.\nPlease enter ID to complete operation",
			"ID required for operation", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// if record alread exists for ID display error message
		if (data.containsKey(idField.getText())) {
			JOptionPane.showMessageDialog(null, 
			"ID is already in data base!\nPlease use different ID,\nor update/delete record",
			"ID Already Exists", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// if no values entered for Name and Major notify user of error
		if (nameField.getText().equals("") || majorField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
			"Name, or Major not entered.\nPlease make sure a Major are entered when\nadding students to records",
			"Student information not enterd", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// if no issues, create student and add, and notify of success
		Student student = new Student(nameField.getText(), majorField.getText());
		data.put(idField.getText(), student);
		
		JOptionPane.showMessageDialog(null, 
		"Student successfully added to records!",
		"Sucess", JOptionPane.PLAIN_MESSAGE);
	}
	
	private void delete() {
		if (idField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
			"No ID entered.\nPlease enter ID to complete operation",
			"ID required for operation", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// if key found delete, else display error
		if (data.containsKey(idField.getText())) {
			data.remove(idField.getText());
			JOptionPane.showMessageDialog(null, 
			"Record sucessfully removed!",
			"Success", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, 
			"Student ID entered could not be found!\nPlease try a different ID.",
			"Student Record Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void find() {
		if (idField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
			"No ID entered.\nPlease enter ID to complete operation",
			"ID required for operation", JOptionPane.ERROR_MESSAGE);
			return;
		}
		// search for key; if found invoke toString() else displau error
		if (data.containsKey(idField.getText())) {
			JOptionPane.showMessageDialog(null, 
			data.get(idField.getText()).toString(),
			"Student Found", JOptionPane.PLAIN_MESSAGE);
		} else {
			JOptionPane.showMessageDialog(null, 
			"Student ID entered could not be found!\nPlease try a different ID.",
			"Student Record Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	private void update() {
		if (idField.getText().equals("")) {
			JOptionPane.showMessageDialog(null, 
			"No ID entered.\nPlease enter ID to complete operation",
			"ID required for operation", JOptionPane.ERROR_MESSAGE);
			return;
		}
		
		if (data.containsKey(idField.getText())) {
			// Init JComboBoxes for JOptionPanes
			String[] gradeOptions = {
					"A",
					"B",
					"C",
					"D",
					"F"
			};
			
			gradeCombo = new JComboBox(gradeOptions);
			gradeCombo.setEditable(false);

			String[] creditOptions = {
					"3",
					"6"
			};

			creditCombo = new JComboBox(creditOptions);
			creditCombo.setEditable(false);
			
			// gather data from JOptionPanes
		    JOptionPane.showMessageDialog(null, new Object[]{"Choose grade:", gradeCombo}, "",
		    JOptionPane.QUESTION_MESSAGE);
		    
		    JOptionPane.showMessageDialog(null, new Object[]{"Choose credits:", creditCombo}, "",
		    JOptionPane.QUESTION_MESSAGE);
		    
		    String grade = gradeCombo.getSelectedItem().toString();
		    double hours = Double.parseDouble(creditCombo.getSelectedItem().toString());
		    
			// update records and display success notification
		    data.get(idField.getText()).courseCompleted(grade, hours); // invoke course compelted to update
		    
		    JOptionPane.showMessageDialog(null, 
			"Record successfully updated!",
			"Success", JOptionPane.PLAIN_MESSAGE);
		    
		} else {
			JOptionPane.showMessageDialog(null, 
			"Student ID entered could not be found!\nPlease try a different ID.",
			"Student Record Not Found", JOptionPane.ERROR_MESSAGE);
		}
	}
	
	public static void main(String[] args) {
		// init Gui
		GradesGui gui = new GradesGui();
	}

}
