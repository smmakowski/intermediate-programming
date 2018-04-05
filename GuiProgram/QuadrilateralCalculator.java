import javax.swing.*;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.*;
import java.awt.Font;

public class QuadrilateralCalculator extends JFrame {
  // fields for components
  private JLabel lengthLabel, widthLabel, perimeterLabel, areaLabel, emptyLabel;
  private JTextField lengthField, widthField, perimeterField, areaField;
  private JButton calculateButton;
  // font constants
  private final Font LABELSTYLE = new Font("Arial", Font.BOLD, 28);
  private final Font RESULTSTYLE = new Font("Arial", Font.BOLD, 14);

  // event listener for calculate button
  private ActionListener calcButtonListener = new ActionListener () {
    public void actionPerformed(ActionEvent event) throws NumberFormatException, IllegalArgumentException {
      try {
        // parse input from fields
        double length = Double.parseDouble(lengthField.getText());
        double width = Double.parseDouble(widthField.getText());
        // throw exception if not positive number
        if (length <= 0 || width <= 0) {
          throw new IllegalArgumentException();
        }
        // calculate values
        double perimeter = (length * 2) + (width * 2);
        double area = length * width;
        // set results fields
        areaField.setText(Double.toString(area) + " Square Units");
        perimeterField.setText(Double.toString(perimeter) + " Units");
      } catch (NumberFormatException e) { // catches exxceptions when parsing input
        JOptionPane.showMessageDialog(null, "The Length and/or Width you have entered could not be parsed.\n" +
        "Please make sure a valid number is entered (Examples: 200, 100.1, etc.)", "Error", JOptionPane.ERROR_MESSAGE);
        areaField.setText("");
        perimeterField.setText("");
        lengthField.setText("");
        widthField.setText("");
      } catch (IllegalArgumentException e) { // handle exception using optionpane
        JOptionPane.showMessageDialog(null, "The Length and/or Width you have entered is less than or equal to 0.\n" +
        "Please make sure the numbers entered are positive (Examples: 421, 9999.92, etc.)", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  };
  // GUI contructor
  public QuadrilateralCalculator() {
    setTitle("Quadrilateral Calculator");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);
    // creates a panel laybout
    JPanel mainPanel = new JPanel(new GridLayout(5, 2));
    mainPanel.setBackground(Color.LIGHT_GRAY);
    //create set style and add labels
		lengthLabel = new JLabel("Length:");
    lengthLabel.setHorizontalAlignment(JTextField.CENTER);
    lengthLabel.setFont(LABELSTYLE);
		mainPanel.add(lengthLabel);
    // create set style and add field
    lengthField = new JTextField();
    lengthField.setHorizontalAlignment(JTextField.CENTER);
		mainPanel.add(lengthField);

    widthLabel = new JLabel("Width:");
    widthLabel.setHorizontalAlignment(JTextField.CENTER);
    widthLabel.setFont(LABELSTYLE);
		mainPanel.add(widthLabel);

		widthField = new JTextField();
    widthField.setHorizontalAlignment(JTextField.CENTER);
		mainPanel.add(widthField);

    perimeterLabel = new JLabel("Perimeter:");
    perimeterLabel.setHorizontalAlignment(JTextField.CENTER);
    perimeterLabel.setFont(LABELSTYLE);
		mainPanel.add(perimeterLabel);

    perimeterField = new JTextField();
    perimeterField.setHorizontalAlignment(JTextField.CENTER);
    perimeterField.setBackground(Color.LIGHT_GRAY);
    perimeterField.setFont(RESULTSTYLE);
    perimeterField.setForeground(new Color(0, 0, 128));
    mainPanel.add(perimeterField);
    perimeterField.setEditable(false);

    areaLabel = new JLabel("Area:");
    areaLabel.setHorizontalAlignment(JTextField.CENTER);
    areaLabel.setFont(LABELSTYLE);
		mainPanel.add(areaLabel);

    areaField = new JTextField();
    areaField.setHorizontalAlignment(JTextField.CENTER);
    areaField.setBackground(Color.LIGHT_GRAY);
    areaField.setFont(RESULTSTYLE);
    areaField.setForeground(new Color(0, 0, 128));

    mainPanel.add(areaField);
    areaField.setEditable(false);

    emptyLabel = new JLabel("");
    mainPanel.add(emptyLabel);
    // create set style, handlers add button
    calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(calcButtonListener);
    mainPanel.add(calculateButton);
		add(mainPanel);
		setVisible(true);
  }
  // main function inits GUI
  public static void main(String[] args) {
    QuadrilateralCalculator quadCalc = new QuadrilateralCalculator();
  }
}
