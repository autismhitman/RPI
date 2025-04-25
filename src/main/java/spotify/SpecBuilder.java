package spotify;

import io.qameta.allure.restassured.AllureRestAssured;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.filter.log.LogDetail;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;
import spotify.enums.Routes;

public class SpecBuilder {
	
	
	public static RequestSpecification getRequestSpec() {
		
		return   new RequestSpecBuilder()
				.setBaseUri(System.getProperty("BASE_URI", "https://api.spotify.com"))
	            //.setBaseUri("https://api.spotify.com")
	            .setBasePath(Routes.BASEPATH.toString())
	            .setContentType("application/json")
	            .addFilter(new AllureRestAssured())
	            //.addHeader("Authorization", "Bearer "+ access_token)
	            .log(LogDetail.ALL)
	            .build();
	}
	
 	public static RequestSpecification getAccountRequestSpec() {
		
		return   new RequestSpecBuilder()
				.setBaseUri(System.getProperty("ACCOUNT_BASE_URI", "https://accounts.spotify.com"))
	            //.setBaseUri("https://accounts.spotify.com")
	            .addHeader("Content-Type","application/x-www-form-urlencoded")
	            .addHeader("Authorization","Basic OGJmMmIzOTgzNzJiNDE5ZjkyMWFlNGU5YTY5MTAxOGQ6NjNiOWY4MGViODg5NDQ3ODkzODYzN2FhMzQ2OGJhOGM=")
	            .addFilter(new AllureRestAssured())
	            .log(LogDetail.ALL)
	            .build();
	}
	
	public static ResponseSpecification getResponseSpec() {
		
		return   new ResponseSpecBuilder()	             
	            .log(LogDetail.ALL)
	            .build();
	}
	
 

}
