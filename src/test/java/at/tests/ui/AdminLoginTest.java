package at.tests.ui;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import at.study.redmine.allure.asserts.AllureAssert;
import at.study.redmine.model.User;
import io.qameta.allure.Owner;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;

public class AdminLoginTest extends BaseUITest {

    private User user;

    @BeforeMethod(description = "В системе заведен пользователь с правами Администратора. Открыт браузер на главной странице")
    public void prepareFixtures() {
        user = new User() {{
            setIsAdmin(true);
        }}.create();

        openBrowser();
    }

    @Test(description = "Вход администратором. Проверка наличия элемента \"Моя учётная запись\"")
    @Severity(SeverityLevel.BLOCKER)
    @Owner("Левченко Георгий Александрович")
    public void loginAsAdminTest() {
        headerPage.loginButton.click();
        loginPage.login(user);
        AllureAssert.assertEquals(
                headerPage.myAccount.getText(),
                "Моя учётная запись",
                "Текст элемента - \"Моя учётная запись\""
        );

    }

}
