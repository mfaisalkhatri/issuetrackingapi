package com.mfaisalkhatri.issuestrackingapi.tests;

import java.io.IOException;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.mfaisalkhatri.issuestrackingapi.configreader.ConfigProperties;

import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.response.ResponseBody;
import io.restassured.specification.RequestSpecification;


public class RestApiGetTest {

	@Test
	public void test1() throws IOException {

		ConfigProperties config = new ConfigProperties();
		String request = config.getRqstType();
		if (request != null) {
			if (request.equals("GET")) {
//				Response resp = RestAssured.get(config.getRqstUrl());
//				System.out.println("Called Get rqst");
//				int code = resp.getStatusCode();
//				System.out.println("Status Code is: " + code);
//				Assert.assertEquals(code, 200);
//
//				String data = resp.asString();
//				System.out.println("Data is" + data);
//				ResponseBody respBody = resp.getBody();
//				System.out.println("Body is: " + respBody.asString());
//
//				String body = respBody.asString();
//				Assert.assertEquals(body.contains("51"), true);
//				Assert.assertEquals(body.contains("Clean up project and update out dated dependencies."), true);

				RestAssured.baseURI = config.getRqstUrl();
				RequestSpecification httpRequest = RestAssured.given();
				Response response = httpRequest.request(Method.GET);

				String responseBody = response.getBody().asString();
				System.out.println("Response is Body is " + responseBody);
				
				int status = response.getStatusCode();
				Assert.assertEquals(status, 200);
				Assert.assertEquals(responseBody.contains("51"), true);
				Assert.assertEquals(responseBody.contains("Clean up project and update out dated dependencies"), true);
				
			} else if (request.equals("POST")) {
				RestAssured.baseURI = config.getRqstUrl();
				RequestSpecification httpRequest = RestAssured.given();
				
				JSONObject requestParams = new JSONObject();
				requestParams.put(config.getPostBodyParamKey1(), config.getPostBodyParamValue1()); 
				
				httpRequest.header(config.getHeaderk1(), config.getHeaderv1());
				 
				// Add the Json to the body of the request
				httpRequest.body(requestParams.toJSONString());
				 
				// Post the request and check the response
				Response response = httpRequest.post();
				
				int status = response.getStatusCode();
				Assert.assertEquals(status, 200);
				
				
			} else {
				System.out.println("Value for request is Invalid in config file!");
			}
		}

	}
}
