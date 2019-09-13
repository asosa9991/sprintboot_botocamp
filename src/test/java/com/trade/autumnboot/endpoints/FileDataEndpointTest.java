package com.trade.autumnboot.endpoints;

import static io.restassured.RestAssured.given;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.junit4.SpringRunner;

import io.restassured.RestAssured;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = RANDOM_PORT)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)

public class FileDataEndpointTest {
	@LocalServerPort
	private int serverPort;

	@Before
	public void init() {
		RestAssured.port = serverPort;
	}

	@Test
	public void returnAllFiles() throws Exception {
		given().when().get("/datafiles").then().statusCode(200);
	}
	
	@Test
	public void deleteTheFile() throws Exception {
		given().when().delete("/datafiles/filename.txt").then().statusCode(200);
	}

}
