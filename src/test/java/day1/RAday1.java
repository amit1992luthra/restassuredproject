package day1;

import org.json.simple.JSONObject;
import org.testng.annotations.DataProvider;
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
			.headers("content-type","application/json")
			.body(bodyvariable).
		when()
			.post("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
			
		
		
	}
	
	@SuppressWarnings("unchecked")
	@Test(enabled = false)
	public void testcase5()
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject obj = new JSONObject();
		//creating json body 
		//this put is your json object class function 
		//its not http method
		
		obj.put("name", "xyz");
		//obj.put("batchno", 2);
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.patch("ibmstudents/26").
		then()
			.statusCode(200)
			.log().all();
			
		
		
	}
	
	
	@Test(enabled = false)
	public void testcase6()
	{
		RestAssured.baseURI="https://petstore.swagger.io/v2";
		
	
		given()
		.queryParam("username", "amit")
		.queryParam("password", "123654789").log().all().
		when()
			.get("/user/login").
		then()
			.statusCode(200)
			.log().all();
			
		
	}
	
	@DataProvider(name="testdata")
	public Object[][] data()
	{
		Object[][] studentsdata = new Object[2][2];
		studentsdata[0][0]= "amit";
		studentsdata[0][1]= "5";
		studentsdata[1][0]= "saif";
		studentsdata[1][1]= "6";
		return studentsdata;
		
	}
	
	@Test(enabled = true,dataProvider="testdata")
	public void testcase7(String fname,String bno)
	{
		RestAssured.baseURI="http://localhost:3000/";
		
		JSONObject obj = new JSONObject();
		//creating json body 
		//this put is your json object class function 
		//its not http method
		
		obj.put("name", fname);
		obj.put("batchno", bno);
		
		given()
			.headers("content-type","application/json")
			.body(obj.toJSONString()).
		when()
			.post("ibmstudents").
		then()
			.statusCode(201)
			.log().all();
			
		
		
	}
	
	
	
	
	
}


