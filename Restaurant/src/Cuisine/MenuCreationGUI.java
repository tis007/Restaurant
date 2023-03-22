package Cuisine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import com.fasterxml.jackson.core.JsonProcessingException;

@SuppressWarnings("serial")
public class MenuCreationGUI extends JFrame {
	private int width;
	private int height;
	private Menu menu = new Menu();
	private ArrayList<OrderException> exceptionsList;

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
		southPanel.setLayout(new GridLayout(1, 2));
		this.add(southPanel, BorderLayout.SOUTH);
		
		JPanel southLeftPanel = new JPanel();
		southLeftPanel.setLayout(new FlowLayout(FlowLayout.LEADING));
		southPanel.add(southLeftPanel);
		
		JButton treatCommand = new JButton("treat command");
		treatCommand.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				exceptionsList = new ArrayList<OrderException>();
				Cuisine cuisine = new Cuisine(menu);
				File dir = new File("C:\\Users\\31tis\\git\\repository\\Restaurant");
				File[] foundFiles = dir.listFiles(new FilenameFilter() {
				    public boolean accept(File dir, String name) {
				        return name.startsWith("order_") && name.endsWith(".json");
				    }
				});

				for (File file : foundFiles) {
					try {
						cuisine.treatOrder(file);
					} catch (IOException | OrderException e1) {
						System.err.println(e1.getMessage());
					}
					
				}    
			}
		});
		southLeftPanel.add(treatCommand);
		
		JPanel southRightPanel = new JPanel();
		southRightPanel.setLayout(new FlowLayout(FlowLayout.TRAILING));
		southPanel.add(southRightPanel);
		
		JButton createButton = new JButton("create Menu");
		southRightPanel.add(createButton);
		createButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					menu.createJson();
				} catch (JsonProcessingException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		
		JButton cancelBtn = new JButton("cancel");
		southRightPanel.add(cancelBtn);
		cancelBtn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});
		
		this.setVisible(true);
	}

}
