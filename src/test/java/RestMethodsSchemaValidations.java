
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
import org.testng.annotations.Test;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.matcher.RestAssuredMatchers;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.response.Response;

public class RestMethodsSchemaValidations {

	@Test
	public void getMethodValidation() {

		given()

		.when().get("https://reqres.in/api/users/2")
		
		.then()
		.assertThat().body(JsonSchemaValidator.matchesJsonSchemaInClasspath(".\\filejson.json"));
		
		//for xml schema 
		
		given()

		.when().get("https://reqres.in/api/users/2")
		
		.then()
		.assertThat().body(RestAssuredMatchers.matchesXsdInClasspath(""));
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
		
		
		  RestMethodsPojo data = new RestMethodsPojo(); 
		  data.setName("morpheus");
		  data.setJob("leader");
		  
		  //pojo to JSONObject
		  
		  ObjectMapper mapper = new ObjectMapper();
		 String serdata =  mapper.writerWithDefaultPrettyPrinter().writeValueAsString(data);
		 System.out.println(serdata);
		
		//Using External JSon files
		
		File file = new File(".\\body.json");
		FileReader fr = new FileReader(file);
		
		Scanner fs = new Scanner(file);
		while(fs.hasNextLine())
		{
			System.out.println(fs.nextLine());
		}
		JSONTokener jt = new JSONTokener(fr);
		
		JSONObject jsondata = new JSONObject(jt);

		given().contentType("application/json").body(serdata)

				.when().post("https://reqres.in/api/users")
				.then().log().all();
		
	}

}
