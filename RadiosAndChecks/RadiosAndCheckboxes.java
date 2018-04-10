import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadiosAndCheckboxes extends JFrame {
  // font style constant
  private final Font TEXTSTYLE = new Font("Arial", Font.PLAIN, 14);

  // event listener for main button
  private ActionListener mainButtonListener = new ActionListener () {
    public void actionPerformed(ActionEvent event) {
    // do something
    }
  };
  // GUI contructor
  public RadiosAndCheckboxes() {
    setTitle("Radios and Checkboxes (Placeholder)");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new GridBagLayout());
    getContentPane().add(mainPanel);
    GridBagConstraints gb = new GridBagConstraints();

    JRadioButton aRadio = new JRadioButton("A", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 0; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    aRadio.setFont(TEXTSTYLE);
    mainPanel.add(aRadio, gb); // add to panel

    JRadioButton bRadio = new JRadioButton("B", true);
    gb.gridx = 1;
    gb.gridy = 0;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    bRadio.setFont(TEXTSTYLE);
    mainPanel.add(bRadio, gb);

    JRadioButton cRadio = new JRadioButton("C", true);
    gb.gridx = 2;
    gb.gridy = 0;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    cRadio.setFont(TEXTSTYLE);
    mainPanel.add(cRadio, gb);

    ButtonGroup radioGroup = new ButtonGroup();
    radioGroup.add(aRadio);
    radioGroup.add(bRadio);
    radioGroup.add(cRadio);

    JCheckBox aCheckbox = new JCheckBox("A");
    gb.gridx = 0;
    gb.gridy = 1;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    aCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(aCheckbox, gb);

    JCheckBox bCheckbox = new JCheckBox("B");
    gb.gridx = 1;
    gb.gridy = 1;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    bCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(bCheckbox, gb);

    JCheckBox cCheckbox = new JCheckBox("C");
    gb.gridx = 2;
    gb.gridy = 1;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    cCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(cCheckbox, gb);

    ButtonGroup checkboxGroup = new ButtonGroup();
    radioGroup.add(aCheckbox);
    radioGroup.add(bCheckbox);
    radioGroup.add(cCheckbox);

		setVisible(true);
  }
  // main function inits GUI
  public static void main(String[] args) {
    RadiosAndCheckboxes radiosAndCheckboxesGui = new RadiosAndCheckboxes();
  }
}
