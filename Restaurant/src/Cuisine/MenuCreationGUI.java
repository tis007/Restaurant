package Cuisine;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class MenuCreationGUI extends JFrame {
	private int width;
	private int height;
	private Menu menu = new Menu();

	public MenuCreationGUI(int width, int height, String title) {
		super(title);
		this.width = width;
		this.height = height;
		this.setUpAndDisplay();
	}
	
	public MenuCreationGUI() {
		this(400, 400, "MenuCreation");
	}
	
	public void setUpAndDisplay() {
		this.setVisible(true);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));
		
		JPanel northLabelPanel = new JPanel();
		JLabel northLabel = new JLabel("Menu Creation");
		northLabel.setFont(new Font("Arial", Font.PLAIN, 30));
		northLabelPanel.add(northLabel);
		this.add(northLabelPanel, BorderLayout.NORTH);
		
		JPanel CenterGridLayout = new JPanel();
		CenterGridLayout.setLayout(new GridLayout(3, 1));
		this.add(CenterGridLayout);
		CenterGridLayout.add(new CoursePanelGUI("starters", menu));
		CenterGridLayout.add(new CoursePanelGUI("main_courses", menu));
		CenterGridLayout.add(new CoursePanelGUI("desserts", menu));

	}

}
