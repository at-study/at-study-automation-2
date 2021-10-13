package at.tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.redmine.model.User;
import lombok.SneakyThrows;

import static org.testng.Assert.assertEquals;

public class AdminLoginTest3 extends BaseUITest {

    private User user;

    @BeforeMethod
    public void prepareFixtures() {
        user = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser();
    }

    @Test
    @SneakyThrows
    public void loginAsAdminTest() {
        headerPage.loginButton.click();
        loginPage.login(user);
        assertEquals(headerPage.myAccount.getText(), "Моя учётная запись");
    }

}
