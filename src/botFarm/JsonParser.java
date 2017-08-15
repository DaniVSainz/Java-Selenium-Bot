package botFarm;

import java.awt.AWTException;
import java.awt.Robot;
import java.util.Arrays;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

public class JsonParser {

	static String[] myUser = new String[6];
	static FakestUser fakeUser;
	

//	Parses the string return from getRequest and assigns the values to a Array of Strings to be passed back
//	to our bot
	public static FakestUser parseUserString(String jsonString) {
		JsonArray array = Json.parse(jsonString).asObject().get("results").asArray();
		
		myUser[0] = array.get(0).asObject().get("gender").toString();
		myUser[1] = array.get(0).asObject().get("name").asObject().get("first").toString();
		myUser[2] = array.get(0).asObject().get("name").asObject().get("last").toString();
		myUser[3] = array.get(0).asObject().get("location").asObject().get("city").toString();
		myUser[4] = array.get(0).asObject().get("location").asObject().get("state").toString();
		myUser[5] = array.get(0).asObject().get("picture").asObject().get("large").toString();
		System.out.println(myUser);
		return returnUser(myUser);

	}
	
//	Sends data off to UserFactory and sets the date so i can use it happily ever after..
	public static FakestUser returnUser(String[] myUser) {
		fakeUser = new FakestUser(myUser);
		return fakeUser;
		
	}
	

}
