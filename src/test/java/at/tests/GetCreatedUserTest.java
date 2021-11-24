package at.tests;

import java.util.Collections;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.redmine.api.client.RestApiClient;
import at.study.redmine.api.client.RestMethod;
import at.study.redmine.api.client.RestRequest;
import at.study.redmine.api.client.RestResponse;
import at.study.redmine.api.dto.users.UserDto;
import at.study.redmine.api.dto.users.UserInfoDto;
import at.study.redmine.api.rest_assured.RestAssuredClient;
import at.study.redmine.api.rest_assured.RestAssuredRequest;
import at.study.redmine.model.Token;
import at.study.redmine.model.User;
import at.study.redmine.model.user.Status;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertNull;

public class GetCreatedUserTest {
    private User createdUser;
    private RestApiClient client;
    private RestRequest request;


    @BeforeMethod
    public void prepareFixtures() {

        createdUser = new User() {{
            setStatus(Status.UNACCEPTED);
        }}.create();

        User apiUser = new User() {{
            setTokens(Collections.singletonList(new Token(this)));
            setIsAdmin(true);
        }}.create();

        client = new RestAssuredClient(apiUser);

        Integer createdUserId = createdUser.getId();

        request = new RestAssuredRequest(RestMethod.GET, "/users/" + createdUserId + ".json", null, null, null);

    }

    @Test
    public void getCreatedUserTest() {
        RestResponse response = client.execute(request);

        assertEquals(response.getStatusCode(), 200);

        UserInfoDto responseData = response.getPayload(UserInfoDto.class);
        UserDto responseUser = responseData.getUser();

        assertEquals(responseUser.getLastName(), createdUser.getLastName());
        assertEquals(responseUser.getFirstName(), createdUser.getFirstName());
        assertEquals(responseUser.getAdmin(), createdUser.getIsAdmin());
        assertNull(responseUser.getMail());
        assertEquals(responseUser.getStatus().intValue(), createdUser.getStatus().statusCode);
    }

}
