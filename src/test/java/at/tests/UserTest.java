package at.tests;

import org.testng.annotations.Test;

import at.study.redmine.model.User;

public class UserTest {

    @Test
    public void createUserObjectTest() {
        User user = new User();
        user.setFirstName("Иван");
        user.setLastName("Петров");
    }
}
