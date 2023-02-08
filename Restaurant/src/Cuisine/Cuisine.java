package Cuisine;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.core.exc.StreamReadException;
import com.fasterxml.jackson.databind.DatabindException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class Cuisine {
	ObjectMapper mapper = new ObjectMapper();
	Menu menu = new Menu();

	public Cuisine() {
		menu = new Menu();
	}

	public void addMenu(Menu menu) {
		this.menu = menu;
	}

	@SuppressWarnings("unchecked")
	public void treatOrder(String FileName) throws StreamReadException, DatabindException, IOException, OrderException {
		Map<?, ?> orderMap = mapper.readValue(new File(FileName), Map.class);
		System.out.println(orderMap);
		if (!checkIfOrderCanBeFullfilled(orderMap)) {
			throw new OrderException("Order can't be fullfilled, here is the menu \n" + menu);
		}
		removeAllQty(orderMap);
	}
	
	@SuppressWarnings("unchecked")
	public void removeAllQty(Map<?, ?> order) {
		ArrayList<HashMap<String, Integer>> starters = (ArrayList<HashMap<String, Integer>>) order.get("starters");
		removeQtyList("starters", starters);
		ArrayList<HashMap<String, Integer>> main_courses = (ArrayList<HashMap<String, Integer>>) order.get("main_courses");
		removeQtyList("main_courses", main_courses);
		ArrayList<HashMap<String, Integer>> desserts = (ArrayList<HashMap<String, Integer>>) order.get("desserts");
		removeQtyList("desserts", desserts);
	}

	public void removeQtyList(String course, ArrayList<HashMap<String, Integer>> plats) {
		for (int i = 0; i < plats.size(); i++) {
			removeQty(course, plats.get(i).get("id"), plats.get(i).get("qty"));
		}
	}

	public void removeQty(String course, int id, int nbr) {
		menu.removeQty(course, id, nbr);
	}

	@SuppressWarnings("unchecked")
	public Boolean checkIfOrderCanBeFullfilled(Map<?, ?> order) {
		ArrayList<HashMap<String, Integer>> starters = (ArrayList<HashMap<String, Integer>>) order.get("starters");
		ArrayList<HashMap<String, Integer>> main_courses = (ArrayList<HashMap<String, Integer>>) order.get("main_courses");
		ArrayList<HashMap<String, Integer>> desserts = (ArrayList<HashMap<String, Integer>>) order.get("desserts");
		if (testEnoughList("starters", starters) && testEnoughList("main_courses", main_courses)
				&& testEnoughList("desserts", desserts)) {
			return true;
		} else {
			return false;
		}
	}

	public Boolean testEnoughList(String course, ArrayList<HashMap<String, Integer>> plats) {
		for (int i = 0; i < plats.size(); i++) {
			if (!testEnough(course, plats.get(i).get("id"), plats.get(i).get("qty"))) {
				return false;
			}
		}
		return true;
	}

	public Boolean testEnough(String courseName, int id, int nbr) {
		if (((menu.getNumberOf(courseName, id) - nbr) < 0)) {
			return false;
		} else {
			return true;
		}
	}
}
