package com.trade.autumnboot.endpoints;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import com.trade.autumnboot.dto.MockDataRequest;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class MockDataEndpointTest {
	@LocalServerPort
	private int serverPort;

	@Autowired
	MockDataRequest mockDataRequest;

	@Before
	public void init() {
		RestAssured.port = serverPort;
	}

	@Test
	public void mockdata_returns_400_with_invalid_request() throws Exception {
		given().contentType("application/json").body(mockDataRequest).when().post("/mockdata").then().statusCode(400);
	}

	@Test
	public void mockdata_returns_200_with_valid_request() throws Exception {
		mockDataRequest.setGeneratorType("Function1");
		mockDataRequest.setNumOfDays(2);
		mockDataRequest.setStartDate(LocalDate.now());
		mockDataRequest.setTicker("AAPL");
		given().contentType("application/json").body(mockDataRequest).when().post("/mockdata").then().statusCode(200);
	}

	@Test
	public void mockdata_generator_meta_returns_200() throws Exception {
		given().when().get("/mockdata/generator/meta").then().statusCode(200).body("Function1", equalTo("This is a linear mock data generator"));
	}
	
	

}
