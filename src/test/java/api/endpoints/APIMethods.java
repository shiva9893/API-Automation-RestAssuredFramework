package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.*;

public class APIMethods {

	public static Response getUser() {

		Response response = null;
		try {
			response = given().contentType(ContentType.JSON).accept(ContentType.JSON).when().get(EndPointsURLs.users_Url);
		} catch (Exception e) {
			System.out.println(e);
		}
		return response;
	}

	public static Response getUsersByID(int id) {

		Response response = null;
		try {
			response = given().contentType(ContentType.JSON).accept(ContentType.JSON).pathParam("id", id).when()
					.get(EndPointsURLs.usersID_Url);
		} catch (Exception e) {
			System.out.println(e);
		}
		return response;
	}

}
