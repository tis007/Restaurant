package Cuisine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CuisineGUI extends JFrame{
	private int width;
	private int height;

	public CuisineGUI(int width, int height, String title) {
		super(title);
		this.width = width;
		this.height = height;
		this.setUpAndDisplay();
	}
	
	public CuisineGUI() {
		this(550, 700, "Cuisine");
	}
	
	public void setUpAndDisplay() {
		this.setVisible(true);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel topPanel = new JPanel();
		topPanel.setLayout(new FlowLayout());
		this.add(topPanel, BorderLayout.NORTH);
		
		JLabel topLabel = new JLabel("CUISINE");
		topPanel.add(topLabel);
	}

}
