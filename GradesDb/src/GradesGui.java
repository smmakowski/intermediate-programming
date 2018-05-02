import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GradesGui extends JFrame {
	private JComboBox crudCombo, creditCombo, gradeCombo;
	private JLabel idLabel, nameLabel, majorLabel, crudLabel;
	private JTextField idField, nameField, majorField;
	private JButton processButton;
	
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
		
		String[] gradeOptions = {
				"A",
				"B",
				"C",
				"D",
				"F"
		};
		
		String[] creditOptions = {
				"3",
				"6"
		};
		
		setVisible(true);
	}
	
	public static void main(String[] args) {
		// init Gui
		GradesGui gui = new GradesGui();
	}

}
