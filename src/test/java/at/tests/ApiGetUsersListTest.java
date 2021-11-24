package at.tests;

import java.util.Collections;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.redmine.api.client.RestApiClient;
import at.study.redmine.api.client.RestRequest;
import at.study.redmine.api.client.RestResponse;
import at.study.redmine.api.dto.users.UsersListDto;
import at.study.redmine.api.rest_assured.RestAssuredClient;
import at.study.redmine.api.rest_assured.RestAssuredRequest;
import at.study.redmine.model.Token;
import at.study.redmine.model.User;

import static at.study.redmine.api.client.RestMethod.GET;

public class ApiGetUsersListTest {

    private RestApiClient client;
    private RestRequest request;

    @BeforeMethod
    public void prepareFixtures() {
        User user = new User() {{
            setIsAdmin(true);
            setTokens(Collections.singletonList(new Token(this)));
        }}.create();

        client = new RestAssuredClient(user);

        request = new RestAssuredRequest(GET, "/users.json", null, null, null);
    }

    @Test
    public void apiGetUsersListTest() {

        RestResponse response = client.execute(request);

        Assert.assertEquals(response.getStatusCode(), 200);

        UsersListDto responseData = response.getPayload(UsersListDto.class);

        Assert.assertEquals(responseData.getLimit().intValue(), 25);

    }

}
