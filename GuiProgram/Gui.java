import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
  // constructor sets layout for window
  public Gui() {
    setTitle("Quadrilateral Calculator");
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel mainPanel = new JPanel(new GridLayout(5, 2));

		JLabel lengthLabel = new JLabel("Length:");
		mainPanel.add(lengthLabel);

    JTextField lengthField = new JTextField();
		mainPanel.add(lengthField);

    JLabel widthLabel = new JLabel("Width:");
		mainPanel.add(widthLabel);

		JTextField widthField = new JTextField();
		mainPanel.add(widthField);

    JLabel perimeterLabel = new JLabel("Perimeter:");
		mainPanel.add(perimeterLabel);

    JTextField perimeterField = new JTextField();
    mainPanel.add(perimeterField);

    JLabel areaLabel = new JLabel("Area:");
		mainPanel.add(areaLabel);

    JTextField areaField = new JTextField();
    mainPanel.add(areaField);

    JLabel messageLabel = new JLabel("");
    mainPanel.add(messageLabel);

    JButton calculateButton = new JButton("Calculate");
		// button.addActionListener(this.calculate);
    mainPanel.add(calculateButton);
		add(mainPanel);
		setVisible(true);
  }
}
