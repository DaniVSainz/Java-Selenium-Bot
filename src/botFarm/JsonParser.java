package botFarm;

import java.awt.AWTException;
import java.awt.Robot;

import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonArray;
import com.eclipsesource.json.JsonValue;

public class JsonParser {


	public static JsonValue parseNewUser(String jsonString) {
		JsonArray array = Json.parse(jsonString).asObject().get("results").asArray();
		JsonValue values = array.get(0).asObject().get("picture").asObject().get("large");
		System.out.println(values);
		return array.get(0);
	}
	
	public static void main(String[] args) {
		try {
		    // These coordinates are screen coordinates
		    int xCoord = 500;
		    int yCoord = 500;

		    // Move the cursor
		    Robot robot = new Robot();
		    robot.mouseMove(xCoord, yCoord);
		} catch (AWTException e) {
		}
		System.out.println("cursor moved");
	}
}
