package data;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;


public class JsonDataReader 
{
	public String firstname, lastname , email , password  ; 

	public void JsonReader() throws IOException, ParseException 
	{
		String filePath = System.getProperty("user.dir")+"/src/test/java/data/UserData.json";

		File srcFile = new File(filePath); 

		JSONParser parser = new JSONParser(); 
		JSONArray jarray = (JSONArray)parser.parse(new FileReader(srcFile)); 

		for(Object jsonObj : jarray) 
		{
			JSONObject person = (JSONObject) jsonObj ; 
			firstname  = (String) person.get("firstname"); 
			System.out.println(firstname);

			lastname = (String) person.get("lastname"); 
			System.out.println(lastname);

			email = (String) person.get("email"); 
			System.out.println(email);

			password = (String) person.get("password"); 
			System.out.println(password);

		}

	}

	public void updateJsonFile() throws IOException, ParseException {
		String filePath = System.getProperty("user.dir") + "/src/test/java/data/UserData.json";
		File srcFile = new File(filePath);

		JSONParser parser = new JSONParser();
		JSONArray jarray = (JSONArray) parser.parse(new FileReader(srcFile));

		// Generate random phone number and update it in the JSON object
		Random random = new Random();
		String random3Number = String.format("%03d", random.nextInt(100));
		String newUsername = "ahmed" + random3Number;
		for (Object jsonObj : jarray) {
			JSONObject person = (JSONObject) jsonObj;


			person.put("username", newUsername);

			// Update the JSON file
			try (FileWriter file = new FileWriter(filePath)) {
				file.write(jarray.toJSONString());
				file.flush();
			}
		}

		System.out.println("JSON file updated with new random username." + newUsername);
	}

}
