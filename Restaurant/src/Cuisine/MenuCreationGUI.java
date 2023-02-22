package Cuisine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
		this.setUpAndDisplay(this);
	}
	
	public MenuCreationGUI() {
		this(400, 600, "MenuCreation");
	}
	
	public void setUpAndDisplay(JFrame frame) {
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
		
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		this.add(southPanel, BorderLayout.SOUTH);
		
		JButton cancelBtn = new JButton("cancel");
		southPanel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		this.setVisible(true);

	}

}
