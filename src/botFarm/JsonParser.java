package botFarm;

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
}
