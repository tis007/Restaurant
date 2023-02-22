package Cuisine;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

@SuppressWarnings("serial")
public class CoursePanelGUI extends JPanel {
	private Menu menu;
	private String courseName;
	private ScrollTextArea listItemPanel;

	public CoursePanelGUI(String courseName, Menu menu) {
		this.courseName = courseName;
		this.menu = menu;
		this.setLayout(new GridLayout(2, 1));

		//JScrollPane scrollPane = new JScrollPane(this, JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		this.add(btnPanel);
		
		JButton btn = new JButton(courseName);
		btn.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				NewPlatFrame platFrame = new NewPlatFrame(courseName, menu);
				updateList();
			}
		});
		btnPanel.add(btn);

		listItemPanel = new ScrollTextArea();
		this.add(listItemPanel);

		addMenu(new desserts(1, "aeaze", 234));
		
		listItemPanel.revalidate();
		listItemPanel.repaint();
		this.revalidate();
		this.repaint();
	}
	
	public void addMenu(Plat plat) {
		menu.addPlat(plat);
		updateList();
	}

	public void updateList() {
		ArrayList<Plat> plats = menu.getMenu().get(courseName);
		String txt = "";
		for (Plat plat1 : plats) {
			txt += plat1.description() + "\n";
		}
		listItemPanel.setPaneText(txt);
	}
}
