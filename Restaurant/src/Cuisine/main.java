package Cuisine;

import java.io.IOException;

public class main {

	public static void main(String[] args) throws IOException, OrderException {
		// TODO Auto-generated method stub
		Menu menu = new Menu();
		menu.addPlat(new starters(1, "start1", 40));
		menu.addPlat(new starters(2, "start2", 40));
		menu.addPlat(new starters(3, "start3", 40));

		menu.addPlat(new main_courses(1, "course1", 60));
		menu.addPlat(new main_courses(2, "course2", 50));
		menu.addPlat(new main_courses(3, "course3", 50));

		menu.addPlat(new desserts(1, "dess", 50));
		menu.addPlat(new desserts(2, "azeaz", 50));
		System.out.println(menu);
		menu.createJson();
		
		Cuisine cuisine = new Cuisine();
		cuisine.addMenu(menu);
		cuisine.treatOrder("C:\\Users\\31tis\\git\\repository\\Restaurant\\src\\Cuisine\\restaurant_exemple_commande.json");
	
		MenuCreationGUI GUI = new MenuCreationGUI();
	}

}
