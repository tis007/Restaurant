package Cuisine;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

@SuppressWarnings("serial")
public class InputPanelNbr extends InputPanel {
	JSpinner textField;
	
	
	public InputPanelNbr(String text) {
		super(text);
        SpinnerNumberModel model = new SpinnerNumberModel(0, 0, 99, 1);
        textField = new JSpinner(model);
		JPanel inputField = super.getInpFielPane();
		inputField.setLayout(new FlowLayout());
		inputField.add(textField);
	}

	@Override
	public String getInput() {
		return ""+textField.getValue();
	}
}
