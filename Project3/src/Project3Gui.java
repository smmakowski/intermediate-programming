import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Project3Gui extends JFrame {
	private JRadioButton iterativeRadio, recursiveRadio;
	private JLabel nLabel, resultLabel, efficiencyLabel;
	private JTextField nField, resultField, efficiencyField;
	private JButton computeButton;
	
	public Project3Gui() {
		setTitle("Project 3");
		setSize(375, 250);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    setLocationRelativeTo(null);
		
	    JPanel mainPanel = new JPanel(new GridBagLayout());
	    getContentPane().add(mainPanel);
	    GridBagConstraints gb = new GridBagConstraints();
	    
	    iterativeRadio = new JRadioButton("Iterative", true);
	    gb.gridx = 1;
        gb.gridy = 0;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(iterativeRadio, gb);
        
	    recursiveRadio = new JRadioButton("Recursive");
	    gb.gridx = 1;
        gb.gridy = 1;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(recursiveRadio, gb);
        
        nLabel = new JLabel("Enter n:");
	    gb.gridx = 0;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(nLabel, gb);
        
        nField = new JTextField("");
	    gb.gridx = 1;
        gb.gridy = 2;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(nField, gb);
        
        computeButton = new JButton("Compute");
	    gb.gridx = 1;
        gb.gridy = 3;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(computeButton, gb);
        
        resultLabel = new JLabel("Result:");
	    gb.gridx = 0;
        gb.gridy = 4;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(resultLabel, gb);
        
        resultField = new JTextField("");
	    gb.gridx = 1;
        gb.gridy = 4;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(resultField, gb);
        
        efficiencyLabel = new JLabel("Efficiency:");
	    gb.gridx = 0;
        gb.gridy = 5;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(efficiencyLabel, gb);
        
        efficiencyField = new JTextField("");
	    gb.gridx = 1;
        gb.gridy = 5;
        gb.fill = GridBagConstraints.HORIZONTAL;
        mainPanel.add(efficiencyField, gb);
        
        setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Project3Gui gui = new Project3Gui();
		System.out.println(Sequence.computeIterative(0));
		System.out.println(Sequence.computeIterative(1));
		System.out.println(Sequence.computeIterative(2));
		System.out.println(Sequence.computeIterative(3));
		System.out.println(Sequence.computeIterative(4));
		System.out.println(Sequence.computeIterative(5));
	}

}
