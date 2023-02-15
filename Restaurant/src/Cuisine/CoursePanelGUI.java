package Cuisine;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextPane;

public class CoursePanelGUI extends JPanel {
	private Menu menu;
	private String courseName;
	private JTextPane list;

	public CoursePanelGUI(String courseName, Menu menu) {
		this.courseName = courseName;
		this.menu = menu;
		this.setLayout(new GridLayout(2, 1));

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		this.add(btnPanel);
		btnPanel.add(new JButton(courseName));

		JPanel listItemPanel = new JPanel();
		listItemPanel.setLayout(new FlowLayout());
		this.add(listItemPanel);

		list = new JTextPane();
		addMenu(new desserts(1, "aeaze", 234));

		listItemPanel.add(list);
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
		list.setText(txt);
	}

}
