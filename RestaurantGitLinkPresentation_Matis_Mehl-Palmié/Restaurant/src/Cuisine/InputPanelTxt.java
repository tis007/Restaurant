package Cuisine;

import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class InputPanelTxt extends InputPanel {
	JTextField textField = new JTextField();
	
	
	public InputPanelTxt(String text) {
		super(text);
		JPanel inputField = super.getInpFielPane();
		inputField.add(textField);
	}

	@Override
	public String getInput() {
		return textField.getText();
	}
}
