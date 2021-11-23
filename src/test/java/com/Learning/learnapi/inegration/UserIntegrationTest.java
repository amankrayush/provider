package com.Learning.learnapi.inegration;

import com.Learning.learnapi.model.User;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class UserIntegrationTest {

    @LocalServerPort
    private int port;

    @BeforeEach
    void setUp() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = port;
    }

    @Test
    void createUser() throws JsonProcessingException {
        User user = new User();
        user.setFirstname("rohan");
        user.setEmail("rohan@gmail.com");

        ObjectMapper objectMapper = new ObjectMapper();

        Response response = given().log().all().
                contentType(ContentType.JSON).
                body(objectMapper.writeValueAsString(user)).
                post("/addUser");

        assertEquals(200,response.getStatusCode());
        assertTrue(response.asString().contains(user.getEmail()));
    }
}
