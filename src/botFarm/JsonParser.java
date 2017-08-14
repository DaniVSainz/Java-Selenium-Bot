package botFarm;

import java.awt.AWTException;
import java.awt.Robot;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

public class JsonParser {
	String gender;
	String firstName ;
	String lastName ;
	String nat;
	String location;
	String picture;
	static String[] myUser = new String[6];
	

//	Parses the string return from getRequest and assigns the values to a Array of Strings to be passed back
//	to our bot
	public static JsonValue parseNewUser(String jsonString) {
		JsonArray array = Json.parse(jsonString).asObject().get("results").asArray();
		System.out.println(array);
		System.out.println(array.get(0).asObject().get("name").asObject().get("first"));
		myUser[0] = array.get(0).asObject().get("gender").toString();
		myUser[1] = array.get(0).asObject().get("name").asObject().get("first").toString();
		myUser[2] = array.get(0).asObject().get("name").asObject().get("last").toString();
		myUser[5] = array.get(0).asObject().get("picture").asObject().get("large").toString();
		return array.get(0);
	}
	
	public static void main(String[] args) throws Exception {
		String getUser = "https://randomuser.me/api/?inc=gender,name,nat,location,picture";
		GetRequest requestor = new GetRequest();
		parseNewUser(requestor.get(getUser));
	}
}
