import javax.swing.*;
import java.awt.*;

public class Gui extends JFrame {
  public Gui() {
    this("Gui");
  }
  // constructor sets layout for window
  public Gui(String t) {
    setTitle(t);
    setSize(600, 400);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLocationRelativeTo(null);

    JPanel panel = new JPanel(new GridLayout(4, 2, 0, 10));

		JLabel label = new JLabel("Label: ");
		panel.add(label);

		JTextField textField = new JTextField("", 7);
		panel.add(textField);

    JButton button = new JButton("Calculate");
		// button.addActionListener(this.calculate);
		panel.add(button);

		add(panel);
		setVisible(true);
  }
}
