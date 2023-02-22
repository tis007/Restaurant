package Cuisine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class NewPlatFrame extends JFrame {
	private int width;
	private int height;
	private Plat plat;
	private String courseName;
	private Menu menu;

	public NewPlatFrame(String courseName, Menu menu, int width, int height, String title) {
		super(title);
		this.width = width;
		this.height = height;
		this.courseName = courseName;
		this.menu = menu;
		this.setUpAndDisplay(this);
	}

	public NewPlatFrame(String courseName, Menu menu) {
		this(courseName, menu, 300, 250, "New Plat");
	}

	public void setUpAndDisplay(JFrame frame) {
		this.setVisible(true);
		this.setSize(this.width, this.height);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.setLayout(new BorderLayout(0, 0));

		JPanel northLabelPanel = new JPanel();
		northLabelPanel.setLayout(new FlowLayout());
		this.add(northLabelPanel, BorderLayout.NORTH);

		JLabel northLabel = new JLabel("new " + courseName);
		northLabelPanel.add(northLabel);

		JPanel centerGridPanel = new JPanel();
		centerGridPanel.setLayout(new GridLayout(2, 1));
		this.add(centerGridPanel, BorderLayout.CENTER);
		
		InputPanelTxt topInpPane = new InputPanelTxt("Name :");
		centerGridPanel.add(topInpPane);
		
		InputPanelNbr bottomInpPane = new InputPanelNbr("Quantity :");
		centerGridPanel.add(bottomInpPane);
		
		JPanel southPanel = new JPanel();
		southPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		this.add(southPanel, BorderLayout.SOUTH);
		
		JButton confirmBtn = new JButton("confirm");
		southPanel.add(confirmBtn);
		confirmBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				String name = topInpPane.getInput();
				Integer qty = Integer.parseInt(bottomInpPane.getInput());
				addPlatToMenu(courseName, menu.getMenu().get(courseName).size() + 1 , name, qty);
				frame.dispose();
			}
		});
		
		
		JButton cancelBtn = new JButton("cancel");
		southPanel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		JPanel eastNothing = new JPanel();
		this.add(eastNothing, BorderLayout.EAST);
		JPanel westNothing = new JPanel();
		this.add(westNothing, BorderLayout.WEST);
		
		this.revalidate();
		this.repaint();
	}
	
	public void addPlatToMenu(String courseName, int id, String name, int qty) {
		if (courseName.equals("starters")) {
			addStarter(id, name, qty);
		}
		if (courseName.equals("main_courses")) {
			addMainCourse(id, name, qty);
		}
		if (courseName.equals("desserts")) {
			addDessert(id, name, qty);
		}
	}
	
	public void addStarter(int id, String name, int qty) {
		menu.addPlat(new starters(id, name, qty));
	}
	
	public void addMainCourse(int id, String name, int qty) {
		menu.addPlat(new main_courses(id, name, qty));
	}
	
	public void addDessert(int id, String name, int qty) {
		menu.addPlat(new desserts(id, name, qty));
	}
}
