package botFarm;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

public class JsonParser {
	String gender;
	String firstName ;
	String lastName ;
	String city;
	String state;
	String picture;
	static String[] myUser = new String[6];
	

//	Parses the string return from getRequest and assigns the values to a Array of Strings to be passed back
//	to our bot
	public static String[] parseUserString(String jsonString) {
		JsonArray array = Json.parse(jsonString).asObject().get("results").asArray();
		myUser[0] = array.get(0).asObject().get("gender").toString();
		myUser[1] = array.get(0).asObject().get("name").asObject().get("first").toString();
		myUser[2] = array.get(0).asObject().get("name").asObject().get("last").toString();
		myUser[3] = array.get(0).asObject().get("location").asObject().get("city").toString();
		myUser[4] = array.get(0).asObject().get("location").asObject().get("state").toString();
		myUser[5] = array.get(0).asObject().get("picture").asObject().get("large").toString();
		return myUser;
	}
	
//	Mainly for testing purposes you can ignore or use to test this class.
	public static void main(String[] args) throws Exception {
		String getUser = "https://randomuser.me/api/?inc=gender,name,nat,location,picture";
		GetRequest requestor = new GetRequest();
		System.out.println(Arrays.toString(parseUserString(requestor.get(getUser))));
	}
}
