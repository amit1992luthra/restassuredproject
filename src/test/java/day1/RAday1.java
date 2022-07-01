package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.Test;

import bsh.org.objectweb.asm.Type;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Headers;

import static io.restassured.RestAssured.*;
import io.restassured.response.Response;

public class RAday1 {
	
	@Test(enabled = false)
	public void firsttestcase()
	{
		Response obj = RestAssured.get("http://localhost:3000/ibmstudents");
		System.out.println(obj.asString());
		System.out.println(obj.statusCode());
		System.out.println(obj.headers());
	}

	@Test(enabled = false)
	public void testcase2()
	{
		Response obj = RestAssured.delete("http://localhost:3000/ibmstudents/2");
		System.out.println(obj.asString());
	}
	
	@Test(enabled = false)
	public void testcase3()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		given()
			.get("ibmstudents").
		then()
			.statusCode(200).log().all();
		
		given()
		.delete("ibmstudents/3").
		then()
		.statusCode(200).log().all();
	}
	
	@Test(enabled = false)
	public void testcase4()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		String bodyvariable = "{\"name\":\"shobhit\",\"batchno\":\"2\"}";
		
		given()
			//.contentType(ContentType.JSON)
			//.headers("content-type","application/json")
			.body(bodyvariable).
		when()
			.patch("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
			
		
		
	}
	
	@Test(enabled = true)
	public void testcase5()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject obj = new JSONObject();
		//creating json body 
		//this put is your json object class function 
		//its not http method
		
		obj.put("name", "amit");
		obj.put("batchno", 5);
		
		
		
		
		given()
			//.contentType(ContentType.JSON)
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.post("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
			
		
		
	}
	
	
	
	
	
}


