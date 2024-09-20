
import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

import org.json.JSONObject;
import org.json.JSONTokener;
import org.mozilla.javascript.xml.XMLObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.http.ContentType;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class RestResponseParsingAndFileUploadAndDownLoad {

	@Test
	public void getMethodValidation() {

		Response response = given()

				.when().get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().asPrettyString());
		
		JSONObject object = new JSONObject(response.asString());
		int size = object.getJSONArray("data").length();
		for(int i=0;i<size;i++)
		{
			String emails = object.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(emails);
		}
	}

	@Test
	public void postMethodValidation() throws IOException {

		
		//Using HashMap Sending Post Requests
		/*
		 * HashMap<String, String> data = new HashMap(); data.put("name", "morpheus");
		 * data.put("job", "leader");
		 */
		
		//Using JSONObject  
		/*
		 * JSONObject data = new JSONObject(); data.put("name", "morpheus");
		 * data.put("job", "leader");
		 */
		
		//Using pojo Class
		
		/*
		 * RestMethodsPojo data = new RestMethodsPojo(); data.setName("morpheus");
		 * data.setJob("leader");
		 */
		
		//Using External JSon files
		
		File file = new File(".\\body.json");
		FileReader fr = new FileReader(file);
		
		Scanner fs = new Scanner(file);
		while(fs.hasNextLine())
		{
			System.out.println(fs.nextLine());
		}
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject data = new JSONObject(jt);

		Response res = given().contentType("application/json").body(data.toString())

				.when().post("https://reqres.in/api/users");
		
		System.out.println(res.getBody().asPrettyString());
		Assert.assertEquals(res.getStatusCode(), 201);
		
		
	}
	
	@Test
	public void getMethodValidationForFileUpload() {

		File file = new File(".\\body.json");
		//For One File its File and for Multiple files its Files 
		//More Than one file can be shared by locating all the files and sharing it as list 
		Response response = given().multiPart("File", file).contentType("multipart/form-data")

				.when().get("https://reqres.in/api/users?page=2");
		System.out.println(response.getBody().asPrettyString());
		
		JSONObject object = new JSONObject(response.asString());
		XmlPath object1 = new XmlPath(response.asString());
		int size = object.getJSONArray("data").length();
		for(int i=0;i<size;i++)
		{
			String emails = object.getJSONArray("data").getJSONObject(i).get("email").toString();
			System.out.println(emails);
		}
	}

}
