package Cuisine;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Insets;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

@SuppressWarnings("serial")
public class ScrollTextArea extends JPanel {
	private JTextArea textPane;
	private JScrollPane scrollPane;
	private String text;
	
	public ScrollTextArea() {
		textPane = new JTextArea();
		textPane.setEditable(false);
		textPane.setMargin(new Insets(7, 7, 7, 7));
		scrollPane = new JScrollPane(textPane, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.getVerticalScrollBar().setUnitIncrement(3);
		this.setLayout(new GridLayout(0, 3));
		this.add(new JPanel());
		this.add(scrollPane, BorderLayout.CENTER);
		this.add(new JPanel());

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
