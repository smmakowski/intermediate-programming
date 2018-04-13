import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

public class RadiosAndCheckboxes extends JFrame {
  // font style constant
  private static final Font TEXTSTYLE = new Font("Arial", Font.PLAIN, 14);
  private static final Font HEADSTYLE = new Font("Arial", Font.ITALIC, 14);
  private static final Font BUTTONSTYLE = new Font("Arial", Font.BOLD, 14);

  private JRadioButton wrapRadio, plateRadio, chickenRadio, beefRadio, comboRadio;
  private JCheckBox beverageCheck, baklavaCheck, friesCheck, sauceCheck;
  private JButton orderButton;
  // event listener for main button
  private ActionListener orderButtonListener = new ActionListener () {
    public void actionPerformed(ActionEvent event) {
      double price = 0.0;
      String order = "<You Have Ordered>\n";
      boolean noneSelected = true;

      if (wrapRadio.isSelected()) { // set price for meal type (assumes chicken as protein)
        price += 6.50;
        order += "Wrap";
      } else {
        price += 7.50;
        order += "Plate";
      }
      order += " with ";
      // modify price if not chicken
      if (beefRadio.isSelected()) {
        price += 0.50;
        order += "Beef";
      } else if (comboRadio.isSelected()) {
        price += 1.00;
        order += "Combo Meat";
      } else {
        order += "Chicken";
      }
      order += "\n<Side order(s)>\n";
      // add extras depening on addActionListener
      if (beverageCheck.isSelected()) {
        price += 2.00;
        order += "- Fountain Drink\n";
        noneSelected = false;
      }
      if (baklavaCheck.isSelected()) {
        price += 1.00;
        order += "- Baklava\n";
        noneSelected = false;
      }
      if (friesCheck.isSelected()) {
        price += 3.50;
        order += "- French Fries\n";
        noneSelected = false;
      }
      if (sauceCheck.isSelected()) {
        price += 0.75;
        order += "- EXTRA WHITE SAUCE!!!\n";
        noneSelected = false;
      }

      JOptionPane.showMessageDialog(null,
      "Thank you for ordering!\n" +
      "Your total is : $" + price + ".\n" +
      order + (noneSelected ? "None Selected" : ""),
      "Order Summary",
	    JOptionPane.PLAIN_MESSAGE);
    }
  };
  // GUI contructor
  public RadiosAndCheckboxes() {
    setTitle("Halal Guys Order");
    setSize(650, 250);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new GridBagLayout());
    getContentPane().add(mainPanel);
    GridBagConstraints gb = new GridBagConstraints();

    JLabel typeLabel = new JLabel("What kind of meal would you like?");
    gb.gridx = 1; // set X location on grid
    gb.gridy = 0; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    typeLabel.setFont(HEADSTYLE);
    mainPanel.add(typeLabel, gb); // add to panel

    wrapRadio = new JRadioButton("Wrap ($6.50)", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 1; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    wrapRadio.setFont(TEXTSTYLE);
    mainPanel.add(wrapRadio, gb); // add to panel

    plateRadio = new JRadioButton("Plate (+$1.00)");
    gb.gridx = 2;
    gb.gridy = 1;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    plateRadio.setFont(TEXTSTYLE);
    mainPanel.add(plateRadio, gb);

    ButtonGroup typeGroup = new ButtonGroup();
    typeGroup.add(wrapRadio);
    typeGroup.add(plateRadio);

    JLabel meatLabel = new JLabel("What kind of protein would you like?");
    gb.gridx = 1; // set X location on grid
    gb.gridy = 2; // set Y location on grid
    gb.gridwidth = 3;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    meatLabel.setFont(HEADSTYLE);
    mainPanel.add(meatLabel, gb); // add to panel

    chickenRadio = new JRadioButton("Chicken", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 3; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    chickenRadio.setFont(TEXTSTYLE);
    mainPanel.add(chickenRadio, gb); // add to panel

    beefRadio = new JRadioButton("Beef (+$0.50)", true);
    gb.gridx = 1;
    gb.gridy = 3;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    beefRadio.setFont(TEXTSTYLE);
    mainPanel.add(beefRadio, gb);

    comboRadio = new JRadioButton("Combo (+$1.00)", true);
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

    JLabel addonLabel = new JLabel("Would you like anything else?");
    gb.gridx = 1; // set X location on grid
    gb.gridy = 4; // set Y location on grid
    gb.gridwidth = 3;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    addonLabel.setFont(HEADSTYLE);
    mainPanel.add(addonLabel, gb); // add to panel

    beverageCheck = new JCheckBox("Fountain Drink (+$2.00)");
    gb.gridx = 0;
    gb.gridy = 5;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    beverageCheck.setFont(TEXTSTYLE);
    mainPanel.add(beverageCheck, gb);

    baklavaCheck = new JCheckBox("Baklava (+$1.00)");
    gb.gridx = 2;
    gb.gridy = 5;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    baklavaCheck.setFont(TEXTSTYLE);
    mainPanel.add(baklavaCheck, gb);

    friesCheck = new JCheckBox("French Fries (+$3.50)");
    gb.gridx = 0;
    gb.gridy = 6;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    friesCheck.setFont(TEXTSTYLE);
    mainPanel.add(friesCheck, gb);

    sauceCheck = new JCheckBox("EXTRA WHITE SAUCE (+$0.75)");
    gb.gridx = 2;
    gb.gridy = 6;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    sauceCheck.setFont(TEXTSTYLE);
    mainPanel.add(sauceCheck, gb);

    orderButton = new JButton("PLACE ORDER");
    gb.gridx = 0;
    gb.gridy = 7;
    gb.gridwidth = 3;
    gb.fill = GridBagConstraints.HORIZONTAL;
    orderButton.setFont(TEXTSTYLE);
    mainPanel.add(orderButton, gb);
    orderButton.addActionListener(orderButtonListener);

		setVisible(true);
  }
  // main function inits GUI
  public static void main(String[] args) {
    RadiosAndCheckboxes radiosAndCheckboxesGui = new RadiosAndCheckboxes();
  }
}
