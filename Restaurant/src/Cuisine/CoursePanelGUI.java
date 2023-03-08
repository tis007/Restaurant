package Cuisine;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class CoursePanelGUI extends JPanel {
	private Menu menu;
	private String courseName;
	private ScrollTextArea listItemPanel;
	private CoursePanelGUI thisGui;

	public CoursePanelGUI(String courseName, Menu menu) {
		this.courseName = courseName;
		this.menu = menu;
		this.setLayout(new BorderLayout());
		this.thisGui = this;

		// JScrollPane scrollPane = new JScrollPane(this,
		// JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,
		// JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

		JPanel btnPanel = new JPanel();
		btnPanel.setLayout(new FlowLayout());
		this.add(btnPanel, BorderLayout.NORTH);

		JButton btn = new JButton(courseName);
		btn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				@SuppressWarnings("unused")
				NewPlatFrame platFrame = new NewPlatFrame(courseName, menu, thisGui);
				updateList();
			}
		});
		btnPanel.add(btn, BorderLayout.CENTER);

		listItemPanel = new ScrollTextArea();
		this.add(listItemPanel);
		this.add(new JPanel(), BorderLayout.SOUTH);
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
		listItemPanel.repaint();
	}
}
