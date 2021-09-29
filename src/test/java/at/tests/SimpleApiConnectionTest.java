package at.tests;

import java.util.Collections;

import org.testng.annotations.Test;

import at.study.redmine.api.client.RestApiClient;
import at.study.redmine.api.client.RestMethod;
import at.study.redmine.api.rest_assured.RestAssuredClient;
import at.study.redmine.api.rest_assured.RestAssuredRequest;
import at.study.redmine.model.Token;
import at.study.redmine.model.User;
import io.restassured.http.Method;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class SimpleApiConnectionTest {

    private final RequestSpecification ADMIN_REQUEST_SPECIFICATION = given()
            .baseUri("http://edu-at.dfu.i-teco.ru")
            .header("X-Redmine-API-Key", "55dfd83d5c925f999826c683114e589a4dd9f7e6")
            .log().all();

    @Test
    public void testSimpleRequest() {
        ADMIN_REQUEST_SPECIFICATION
                .request(Method.GET, "/users.json")
                .then()
                .log().all()
                .statusCode(200);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setIsAdmin(true);
        user.setTokens(Collections.singletonList(new Token(user)));

        user.create();

        RestApiClient apiClient = new RestAssuredClient(user);

        apiClient.execute(new RestAssuredRequest(
                RestMethod.GET, "/users.json", null, null, null
        ));

    }

}
