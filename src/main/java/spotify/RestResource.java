package spotify;

import static io.restassured.RestAssured.given;

import java.util.Map;

import io.restassured.response.Response;
import spotify.enums.Routes;

public class RestResource {


		
	public static Response post(String token, String path , Object requestedPlaylist) {

		return given().spec(SpecBuilder.getRequestSpec()).header("Authorization", "Bearer "+ token).body(requestedPlaylist).when()
				.post(path).then().spec(SpecBuilder.getResponseSpec())
				.extract().response();

	}
	
	public static Response postAccount(Map<String, String> queryParams) {
		
		return given().spec(SpecBuilder.getAccountRequestSpec()).queryParams(queryParams)
	           .when().post(Routes.ACCOUNTPATH.toString())
	          .then().spec(SpecBuilder.getResponseSpec())
	          .extract().response();
	}
	 

	public static Response get(String token, String path) {

		return given().spec(SpecBuilder.getRequestSpec()).header("Authorization", "Bearer "+ token).when().get(path).then()
				.spec(SpecBuilder.getResponseSpec()).extract().response();

	}

	public static Response put(String token, String path, Object requestedPlaylist) {

		return given().spec(SpecBuilder.getRequestSpec()).header("Authorization", "Bearer "+ token).body(requestedPlaylist).when().put(path)
				.then().spec(SpecBuilder.getResponseSpec()).extract().response();
	}

}
