package Cuisine;

import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class ScrollTextArea extends JPanel {
	private JTextPane textPane;
	private JScrollPane scrollPane;
	private String text;
	
	public ScrollTextArea() {
		textPane = new JTextPane();
		textPane.setEditable(false);
		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		this.setLayout(new FlowLayout());
		this.add(scrollPane);
	
	}
	
	public void setPaneText(String str) {
		this.text = str;
		textPane.setText(text);
	}
	
	public void addPaneText(String str) {
		this.text += str;
		textPane.setText(text);
	}
}
