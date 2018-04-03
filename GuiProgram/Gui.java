import javax.swing.*;
import java.awt.Font;
import java.awt.event.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Gui extends Jframe implements ActionListener {
  JLabel label;
  JTextField textField;
  JButton button;
  // constructor sets layout for window
  public Gui() {
    this.setSize(600, 400);
    this.setLocationRelativeTo(null);
    this.setTitle("Program");
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panel = new JPanel(new GridBagLayout());
		GridBagConstraints gridBag = new GridBagConstraints();

		label = new JLabel("Label: ");
		ouncesLabel.setFont(new Font("Serif", Font.PLAIN, 28));
		gridBag.gridx = 0;
		gridBag.gridy = 0;
		gridBag.anchor = gridBag.LINE_END;
		panel.add(label, gridBag);

		textField = new JTextField("", 7);
		ouncesTextField.setFont(new Font("Serif", Font.PLAIN, 28));
		gridBag.gridx = 1;
		gridBag.gridy = 0;
		gridBag.anchor = gridBag.LINE_START;
		panel.add(otextField, gridBag);

    button = new JButton("Calculate");
		calculateButton.setFont(new Font("Serif", Font.PLAIN, 28));
		calculateButton.addActionListener(this);
		gridBag.gridx = 1;
		gridBag.gridy = 4;
		panel.add(button, gridBag);

		this.add(panel);
		this.setVisible(true);
  }
  // event handler
  public void calculate(ActionEvent event) {
    GoldPrice gold = new GoldPrice();
    currentPriceTextField.setText(String.valueOf(gold.currentPrice()));
    goldValueTextField.setText(String.valueOf(gold.currentPrice() * Double.parseDouble(ouncesTextField.getText())));
  }
}
