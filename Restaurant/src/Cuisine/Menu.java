package Cuisine;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.TreeMap;

import com.fasterxml.jackson.annotation.JsonAutoDetect.Visibility;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Menu {
	private ArrayList<Plat> starters;
	private ArrayList<Plat> main_courses;
	private ArrayList<Plat> desserts;
	private TreeMap<String, ArrayList<Plat>> menu;
	
	public Menu() {
		starters = new ArrayList<Plat>();
		main_courses = new ArrayList<Plat>();
		desserts = new ArrayList<Plat>();
		menu = new TreeMap<String, ArrayList<Plat>>();

		menu.put("starters", starters);
		menu.put("main_courses", main_courses);
		menu.put("desserts", desserts);
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
	
	public void removeQty(String course, int id, int nbr) {
		getRightPlat(menu.get(course), id).rmQty(nbr);
	}
	
	public int getNumberOf(String course, int id) {
		return getRightPlat(menu.get(course), id).getQty();
	}
	
	public Plat getRightPlat(ArrayList<Plat> platArray, int id) {
		for(Plat plat: platArray) {
			if (plat.getId() == id) {
				return plat;
			}
		}
		return null;
	}
	
	public void createJson() throws JsonProcessingException {
		ObjectMapper mapper = new ObjectMapper();
		mapper.setVisibility(PropertyAccessor.FIELD, Visibility.ANY);
		String jsonString = mapper.writeValueAsString(menu);
		
		try {
		      FileWriter myWriter = new FileWriter("menu.json");
		      myWriter.write(jsonString);
		      myWriter.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
	}

	@Override
	public String toString() {
		return "Menu : \n" + starters + "\n" +main_courses + "\n" + desserts;
	}

	public ArrayList<Plat> getStarters() {
		return starters;
	}

	public ArrayList<Plat> getMain_courses() {
		return main_courses;
	}

	public ArrayList<Plat> getDesserts() {
		return desserts;
	}

	public TreeMap<String, ArrayList<Plat>> getMenu() {
		return menu;
	}
	
}
