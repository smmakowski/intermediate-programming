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
  private ActionListener mainButtonListener = new ActionListener () {
    public void actionPerformed(ActionEvent event) {
    // do something
    }
  };
  // GUI contructor
  public RadiosAndCheckboxes() {
    setTitle("Halal Guys Order");
    setSize(550, 250);
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

    wrapRadio = new JRadioButton("Wrap", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 1; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    wrapRadio.setFont(TEXTSTYLE);
    mainPanel.add(wrapRadio, gb); // add to panel

    plateRadio = new JRadioButton("Plate");
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

    chickenRadio = new JRadioButton("Combo", true);
    gb.gridx = 0; // set X location on grid
    gb.gridy = 3; // set Y location on grid
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL; // set fill for GridBag
    chickenRadio.setFont(TEXTSTYLE);
    mainPanel.add(chickenRadio, gb); // add to panel

    beefRadio = new JRadioButton("Beef", true);
    gb.gridx = 1;
    gb.gridy = 3;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    beefRadio.setFont(TEXTSTYLE);
    mainPanel.add(beefRadio, gb);

    comboRadio = new JRadioButton("Combo", true);
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

    beverageCheck = new JCheckBox("Fountain Drink");
    gb.gridx = 0;
    gb.gridy = 5;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    beverageCheck.setFont(TEXTSTYLE);
    mainPanel.add(beverageCheck, gb);

    baklavaCheck = new JCheckBox("Baklava");
    gb.gridx = 2;
    gb.gridy = 5;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    baklavaCheck.setFont(TEXTSTYLE);
    mainPanel.add(baklavaCheck, gb);

    friesCheck = new JCheckBox("French Fries");
    gb.gridx = 0;
    gb.gridy = 6;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    friesCheck.setFont(TEXTSTYLE);
    mainPanel.add(friesCheck, gb);

    sauceCheck = new JCheckBox("Extra White Sauce");
    gb.gridx = 2;
    gb.gridy = 6;
    gb.gridwidth = 1;
    gb.fill = GridBagConstraints.HORIZONTAL;
    sauceCheck.setFont(TEXTSTYLE);
    mainPanel.add(sauceCheck, gb);

    ButtonGroup addonGroup = new ButtonGroup();
    addonGroup.add(beverageCheck);
    addonGroup.add(baklavaCheck);
    addonGroup.add(friesCheck);
    addonGroup.add(sauceCheck);

    orderButton = new JButton("PLACE ORDER");
    gb.gridx = 0;
    gb.gridy = 7;
    gb.gridwidth = 3;
    gb.fill = GridBagConstraints.HORIZONTAL;
    orderButton.setFont(TEXTSTYLE);
    mainPanel.add(orderButton, gb);

		setVisible(true);
  }
  // main function inits GUI
  public static void main(String[] args) {
    RadiosAndCheckboxes radiosAndCheckboxesGui = new RadiosAndCheckboxes();
  }
}
