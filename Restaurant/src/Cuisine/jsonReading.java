package Cuisine;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class jsonReading {
	  JSONParser parser = new JSONParser();
	  
	  public static void readFile(String fileName) {
		  JSONParser parser = new JSONParser();
		  try {
			  
			   Object obj = parser.parse(new FileReader(fileName));
			 
			   JSONObject jsonObject = (JSONObject) obj;
			   System.out.println(jsonObject);
			 
			  } catch (FileNotFoundException e) {
			   e.printStackTrace();
			  } catch (IOException e) {
			   e.printStackTrace();
			  } catch (ParseException e) {
			   e.printStackTrace();
			  }
	  }

}
