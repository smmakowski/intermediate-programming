import javax.swing.*;
import java.awt.*;

public class QuadrilateralCalculator extends JFrame implements ActionListener {
  // constructor sets layout for window
  private JLabel lengthLabel, widthLabel, perimeterLabel, areaLabel, messageLabel;
  private JTextField lengthField, widthField, perimeterField, areaField;
  private JButton calculateButton;
  private double length;
  private double width;
  private double area;
  private double perimeter;

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
		// button.addActionListener(this.calculate);
    mainPanel.add(calculateButton);
		add(mainPanel);
		setVisible(true);
  }

  public static void main(String[] args) {
    QuadrilateralCalculator quadCalc = new QuadrilateralCalculator();
  }
}
