package api.test;
import static io.restassured.RestAssured.*;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.APIMethods;
import api.payload.userPojo;
import api.utilities.DataProviderClasses;
import io.restassured.response.Response;

public class Tests {
	Faker faker;
	userPojo pojo;
	Response response;
	public org.apache.logging.log4j.Logger logger;

	@BeforeClass
	public void setup() {
		faker = new Faker();
		pojo = new userPojo();

		pojo.setId(faker.number().randomDigit());
		//Logs
		logger = LogManager.getLogger(this.getClass());
		
		
	}
	 
	
	@Test(description = "Getting Users",dataProvider = "Data",dataProviderClass = DataProviderClasses.class)
	
	public void getUSers(String id)
	{
		logger.info("**** Test Starting *****");
		pojo = new userPojo();
		pojo.setId(Integer.valueOf(id))	;
		
		response = APIMethods.getUsersByID(pojo.getId());
		response.then().log().all();
		logger.info("**** End Test ****");
		
	}

}
