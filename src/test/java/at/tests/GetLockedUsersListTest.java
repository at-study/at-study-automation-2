package at.tests;

import java.util.HashMap;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.redmine.api.client.RestApiClient;
import at.study.redmine.api.client.RestRequest;
import at.study.redmine.api.client.RestResponse;
import at.study.redmine.api.dto.users.UserDto;
import at.study.redmine.api.dto.users.UsersListDto;
import at.study.redmine.api.rest_assured.RestAssuredClient;
import at.study.redmine.api.rest_assured.RestAssuredRequest;
import at.study.redmine.model.Email;
import at.study.redmine.model.Token;
import at.study.redmine.model.User;
import at.study.redmine.model.user.Status;

import static at.study.redmine.api.client.RestMethod.GET;
import static java.util.Collections.singletonList;

public class GetLockedUsersListTest {

    private RestApiClient client;
    private RestRequest request;
    private User lockedUser;

    @BeforeMethod
    public void prepareFixtures() {
        User user = new User() {{
            setIsAdmin(true);
            setTokens(singletonList(new Token(this)));
        }}.create();

        lockedUser = new User() {{
            setStatus(Status.LOCKED);
            setEmails(singletonList(new Email(this)));
        }}.create();

        client = new RestAssuredClient(user);

        Map<String, String> lockedUserParams = new HashMap<>();
        lockedUserParams.put("status", "3");

        request = new RestAssuredRequest(GET, "/users.json", null, lockedUserParams, null);
    }

    @Test
    public void getLockedUsersListTest() {

        RestResponse response = client.execute(request);

        Assert.assertEquals(response.getStatusCode(), 200);

        UsersListDto responseData = response.getPayload(UsersListDto.class);

        UserDto lockedUserFromApi = responseData.getUsers().stream().filter(
                userDto -> userDto.getLogin().equals(lockedUser.getLogin())
        ).findFirst().get();

        Assert.assertEquals(lockedUserFromApi.getMail(), lockedUser.getEmails().get(0).getAddress());
        Assert.assertEquals(lockedUserFromApi.getFirstName(), lockedUser.getFirstName());
        Assert.assertEquals(lockedUserFromApi.getLastName(), lockedUser.getLastName());

    }

}
