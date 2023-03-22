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
	private ObjectMapper mapper = new ObjectMapper();
	private Menu menu = new Menu();
	private ArrayList<Plat> platNotFullfilledList;

	public Cuisine(Menu menu) {
		this.menu = menu;
	}
	
	public Cuisine() {
		menu = new Menu();
	}

	public void addMenu(Menu menu) {
		this.menu = menu;
	}
	
	public void treatOrderString(String FileName) throws StreamReadException, DatabindException, IOException, OrderException {
		File file = new File(FileName);
		treatOrder(file);
	}
	
	public void treatOrder(File FileName) throws StreamReadException, DatabindException, IOException, OrderException {
		Map<?, ?> orderMap = mapper.readValue(FileName, Map.class);
		if (!checkIfOrderCanBeFullfilled(orderMap)) {
			throw new OrderException(FileName.getName() + " can't be fullfilled for the items ;\n" + platNotFullfilledList);
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
		platNotFullfilledList = new ArrayList<Plat>();
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
			platNotFullfilledList.add(menu.getPlatCourseID(courseName, id));
			return false;
		} else {
			return true;
		}
	}
}
