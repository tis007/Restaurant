package Cuisine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public abstract class InputPanel extends JPanel {
	private JLabel label;
	JPanel inputFieldPanel = new JPanel();
	
	public InputPanel(String text) {
		label = new JLabel(text);

		
		this.setLayout(new GridLayout(2, 1));
		
		this.add(label);
		label.setHorizontalAlignment(JLabel.CENTER);
		
		inputFieldPanel = new JPanel();
		inputFieldPanel.setLayout(new BorderLayout());
		this.add(inputFieldPanel);
	}
	
	public JPanel getInpFielPane() {
		return inputFieldPanel;
	}
	
	public abstract String getInput();
}
