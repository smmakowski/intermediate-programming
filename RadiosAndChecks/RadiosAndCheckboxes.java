import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RadiosAndCheckboxes extends JFrame {
  // font style constant
  private static final Font TEXTSTYLE = new Font("Arial", Font.PLAIN, 14);
  private JRadioButton sandwichRadio, plateRadio, chickenRadio, gyroRadio, comboRadio;
  private JCheckBox beverageCheck, baklavaCheck, friesCheck, wsauceCheck;
  private JLabel typeLabel, addOnsLabel;
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

    JRadioButton wrapRadio = new JRadioButton("Wrap", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 1; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    wrapRadio.setFont(TEXTSTYLE);
    mainPanel.add(wrapRadio, gb); // add to panel

    JRadioButton plateRadio = new JRadioButton("Plate");
    gb.gridx = 2;
    gb.gridy = 1;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    plateRadio.setFont(TEXTSTYLE);
    mainPanel.add(plateRadio, gb);

    ButtonGroup typeGroup = new ButtonGroup();
    typeGroup.add(wrapRadio);
    typeGroup.add(plateRadio);

    JRadioButton chickenRadio = new JRadioButton("Combo", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 3; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    chickenRadio.setFont(TEXTSTYLE);
    mainPanel.add(chickenRadio, gb); // add to panel

    JRadioButton beefRadio = new JRadioButton("Beef", true);
    gb.gridx = 1;
    gb.gridy = 3;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    beefRadio.setFont(TEXTSTYLE);
    mainPanel.add(beefRadio, gb);

    JRadioButton comboRadio = new JRadioButton("Combo", true);
    gb.gridx = 2;
    gb.gridy = 3;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    comboRadio.setFont(TEXTSTYLE);
    mainPanel.add(comboRadio, gb);

    ButtonGroup meatGroup = new ButtonGroup();
    meatGroup.add(chickenRadio);
    meatGroup.add(beefRadio);
    meatGroup.add(comboRadio);

    JCheckBox beverageCheckbox = new JCheckBox("Fountain Drink");
    gb.gridx = 0;
    gb.gridy = 5;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    beverageCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(beverageCheckbox, gb);

    JCheckBox baklavaCheckbox = new JCheckBox("Baklava");
    gb.gridx = 2;
    gb.gridy = 5;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    baklavaCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(baklavaCheckbox, gb);

    JCheckBox friesCheckbox = new JCheckBox("French Fries");
    gb.gridx = 0;
    gb.gridy = 6;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    friesCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(friesCheckbox, gb);

    JCheckBox sauceCheckbox = new JCheckBox("Extra White Sauce");
    gb.gridx = 2;
    gb.gridy = 6;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    sauceCheckbox.setFont(TEXTSTYLE);
    mainPanel.add(sauceCheckbox, gb);

    ButtonGroup addonGroup = new ButtonGroup();
    addonGroup.add(beverageCheckbox);
    addonGroup.add(baklavaCheckbox);
    addonGroup.add(friesCheckbox);
    addonGroup.add(sauceCheckbox);

		setVisible(true);
  }
  // main function inits GUI
  public static void main(String[] args) {
    RadiosAndCheckboxes radiosAndCheckboxesGui = new RadiosAndCheckboxes();
  }
}
