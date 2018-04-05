import javax.swing.*;
import java.awt.GridLayout;
import java.awt.event.*;

public class QuadrilateralCalculator extends JFrame {
  // constructor sets layout for window
  private JLabel lengthLabel, widthLabel, perimeterLabel, areaLabel, messageLabel;
  private JTextField lengthField, widthField, perimeterField, areaField;
  private JButton calculateButton;
  private double length;
  private double width;
  private double area;
  private double perimeter;

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
      } catch (NumberFormatException e) {
        JOptionPane.showMessageDialog(null, "The Length and/or Width you have entered could not be parsed.\n" +
        "Please make sure a valid number is entered (Examples: 200, 100.1, etc.)", "Error", JOptionPane.ERROR_MESSAGE);
        areaField.setText("");
        perimeterField.setText("");
        lengthField.setText("");
        widthField.setText("");
      } catch (IllegalArgumentException e) {
        JOptionPane.showMessageDialog(null, "The Length and/or Width you have entered is less than or equal to 0.\n" +
        "Please make sure the numbers entered are positive (Examples: 421, 9999.92, etc.)", "Error", JOptionPane.ERROR_MESSAGE);
      }
    }
  };

  public QuadrilateralCalculator() {
    setTitle("Quadrilateral Calculator");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new GridLayout(5, 2));

		lengthLabel = new JLabel("Length:");
		mainPanel.add(lengthLabel);

    lengthField = new JTextField();
		mainPanel.add(lengthField);

    widthLabel = new JLabel("Width:");
		mainPanel.add(widthLabel);

		widthField = new JTextField();
		mainPanel.add(widthField);

    perimeterLabel = new JLabel("Perimeter:");
		mainPanel.add(perimeterLabel);

    perimeterField = new JTextField();
    mainPanel.add(perimeterField);
    perimeterField.setEditable(false);

    areaLabel = new JLabel("Area:");
		mainPanel.add(areaLabel);

    areaField = new JTextField();
    mainPanel.add(areaField);
    areaField.setEditable(false);

    messageLabel = new JLabel("");
    mainPanel.add(messageLabel);

    calculateButton = new JButton("Calculate");
		calculateButton.addActionListener(calcButtonListener);
    mainPanel.add(calculateButton);
		add(mainPanel);
		setVisible(true);
  }

  public static void main(String[] args) {
    QuadrilateralCalculator quadCalc = new QuadrilateralCalculator();
  }
}
