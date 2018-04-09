/**
 * File Name: QuadrilateralGenerator
 * Author: Brandon Robert Register
 * Date: April 6, 2018
 * Purpose: Application exists to create quadrilaterals of
 *   the user specified character, with user specified length and
 *   width,
 */

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QuadrilateralGenerator extends JFrame {

	private JTextField width, length, character, error, lines;
	JTextArea output;
	private JButton submit;
	private JLabel charLabel, widthLabel, lengthLabel, errorLabel, outputLabel, areaLabel;

	// No-argument constructor for QuadrilateralGenerator
	public QuadrilateralGenerator() {
		super("Quadrilateral Generator");
		setFrame(300, 300);
		setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;

		charLabel = new JLabel("Enter a Character: ");
		c.gridx = 0;
		c.gridy = 0;
		c.weightx = 0.5;
		add(charLabel, c);

		widthLabel = new JLabel("Width: ");
		c.gridx = 1;
		c.gridy = 0;
		c.weightx = 0.5;
		add(widthLabel, c);

		lengthLabel = new JLabel("Length: ");
		c.gridx = 2;
		c.gridy = 0;
		c.weightx = 0.5;
		add(lengthLabel, c);

		character = new JTextField();
		c.gridx = 0;
		c.gridy = 1;
		c.weightx = 0.5;
		add(character, c);


		width = new JTextField();
		c.gridx = 1;
		c.gridy = 1;
		c.weightx = 0.5;
		add(width, c);

		length = new JTextField();
		c.gridx = 2;
		c.gridy = 1;
		c.weightx = 0.5;
		add(length, c);

		submit = new JButton("Submit");
		c.gridx = 0;
		c.gridy = 2;
		c.gridwidth = 3;
		add(submit, c);
		//Action listener for the submit button
		submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				// add throw error for negative numbers
				if (Integer.parseInt(width.getText()) < 1 || Integer.parseInt(width.getText()) < 1) {
					throw new IllegalArgumentException();
				}

				String printString = "";
				for (int i = 0; i < Integer.parseInt(width.getText()); i++) {
					for (int j = 0; j < Integer.parseInt(length.getText()); j++) {
						printString += character.getText().charAt(0);
					}
					printString += "\n";
				}
				output.setText(printString);
				error.setText("");
				int linesSize = Integer.parseInt(width.getText()) * Integer.parseInt(length.getText());
				lines.setText(Integer.toString(linesSize));
				} catch (NumberFormatException err) {
					error.setText("Invalid Number for Length and/or Width");
				} catch (StringIndexOutOfBoundsException err) {
					error.setText("No valid character entered");
				} catch(IllegalArgumentException err) { // add handling for newgative/0 numbers
					error.setText("Length or Width is not a positive number");
				}
			}
		});

		outputLabel = new JLabel("Output:");
		c.gridx = 1;
		c.gridy = 3;
		add(outputLabel, c);

		output = new JTextArea();
		c.gridx = 0;
		c.gridy = 4;
		c.gridwidth = 3;
		output.setEditable(false);
		add(output, c);

		areaLabel = new JLabel("Area:");
		c.gridx = 1;
		c.gridy = 5;
		c.gridwidth = 3;
		add(areaLabel, c);

		lines = new JTextField();
		c.gridx = 0;
		c.gridy = 6;
		c.gridwidth = 3;
		lines.setEditable(false);
		add(lines, c);

		errorLabel = new JLabel("Error:");
		c.gridx = 1;
		c.gridy = 7;
		add(errorLabel, c);

		error = new JTextField();
		c.gridx = 0;
		c.gridy = 8;
		c.gridwidth = 3;
		error.setEditable(false);
		add(error, c);


		//remember to have this last
		setVisible(true);
	}

	// method which handles frame settings
	private void setFrame(int width, int height) {
		setSize(width, height);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		QuadrilateralGenerator quad = new QuadrilateralGenerator();
	}
}
