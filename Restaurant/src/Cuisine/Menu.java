package Cuisine;

import java.util.ArrayList;
import java.util.TreeMap;

public class Menu {
	private ArrayList<starters> starters;
	private ArrayList<main_courses> main_courses;
	private ArrayList<desserts> desserts;
	private TreeMap<String, ArrayList<Plat>> menu;
	
	public Menu() {
		starters = new ArrayList<starters>();
		main_courses = new ArrayList<main_courses>();
		desserts = new ArrayList<desserts>();
	}
	
	public void addPlat(Plat plat) {
		if (plat instanceof starters) {
			starters.add((starters) plat);
		} else if (plat instanceof main_courses) {
			main_courses.add((main_courses) plat);
		} else if (plat instanceof desserts) {
			desserts.add((desserts) plat);
		}
	}
	
	
	
}
