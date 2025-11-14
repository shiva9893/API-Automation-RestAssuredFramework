package api.utilities;

import org.json.JSONArray;
import org.json.JSONObject;

public class jsonStringOperations {

	public static void jsonReader(String input) {
		try {

			JSONObject object = new JSONObject(input);
			JSONArray orgArray = object.getJSONArray("organizations");
			for (int i = 0; i < orgArray.length(); i++) {
				JSONObject obj = orgArray.getJSONObject(i);
				System.out.println(obj.getString("name"));
			}
			JSONArray orgArray1 = object.getJSONArray("organizations");
			
			for (int i = 0; i < orgArray1.length(); i++) {
				
				System.out.println(orgArray1.getJSONObject(i).getJSONArray("departments"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	public static void main(String[] args) {

		String input = "{\r\n" + " \"location\": {\r\n" + "   \"country\": \"India\",\r\n"
				+ "   \"state\": \"Uttar Pradesh\",\r\n" + "   \"city\": \"Greater Noida\"\r\n" + " },\r\n"
				+ " \"organizations\": [\r\n" + "   {\r\n" + "     \"name\": \"GeeksforGeeks\",\r\n"
				+ "     \"type\": \"Educational\",\r\n"
				+ "     \"departments\": [\"Computer Science\", \"Mathematics\", \"Physics\"]\r\n" + "   },\r\n"
				+ "   {\r\n" + "     \"name\": \"TechCorp\",\r\n" + "     \"type\": \"Technology\",\r\n"
				+ "     \"departments\": [\"Software Development\", \"Hardware Design\"]\r\n" + "   }\r\n" + " ],\r\n"
				+ " \"projects\": {\r\n" + "   \"ongoing\": [\"ProjectA\", \"ProjectB\"],\r\n"
				+ "   \"completed\": [\"ProjectX\", \"ProjectY\"]\r\n" + " },\r\n" + " \"employees\": [\r\n"
				+ "   {\r\n" + "     \"id\": 101,\r\n" + "     \"name\": \"Alice\",\r\n"
				+ "     \"role\": \"Developer\",\r\n" + "     \"skills\": [\"Python\", \"JavaScript\", \"SQL\"],\r\n"
				+ "     \"address\": {\r\n" + "       \"street\": \"123 Main St\",\r\n"
				+ "       \"city\": \"Noida\",\r\n" + "       \"zip\": \"201301\"\r\n" + "     }\r\n" + "   },\r\n"
				+ "   {\r\n" + "     \"id\": 102,\r\n" + "     \"name\": \"Bob\",\r\n"
				+ "     \"role\": \"Manager\",\r\n" + "     \"skills\": [\"Leadership\", \"Communication\"],\r\n"
				+ "     \"address\": {\r\n" + "       \"street\": \"456 Elm St\",\r\n"
				+ "       \"city\": \"Delhi\",\r\n" + "       \"zip\": \"110001\"\r\n" + "     }\r\n" + "   }\r\n"
				+ " ],\r\n" + " \"metadata\": {\r\n" + "   \"created_at\": \"2023-10-01T10:00:00Z\",\r\n"
				+ "   \"updated_at\": \"2023-10-10T15:30:00Z\",\r\n" + "   \"version\": 1.2\r\n" + " }\r\n" + "}";
		jsonReader(input);
	}

}
