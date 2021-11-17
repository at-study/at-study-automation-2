package at.study.redmine.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.redmine.cucumber.ElementName;
import at.study.redmine.cucumber.PageName;
import at.study.redmine.model.User;
import io.qameta.allure.Step;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@PageName("Страница авторизации")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class LoginPage extends Page {

    @ElementName("Логин")
    @FindBy(xpath = "//input[@id='username']")
    private WebElement userNameInput;

    @ElementName("Пароль")
    @FindBy(xpath = "//input[@id='password']")
    private WebElement passwordInput;

    @ElementName("Вход")
    @FindBy(xpath = "//input[@id='login-submit']")
    private WebElement signInButton;

    @Step("Вход в систему пользователем с логином {0} и паролем {1}")
    public void login(String login, String password) {
        userNameInput.sendKeys(login);
        passwordInput.sendKeys(password);
        signInButton.click();
    }

    public void login(User user) {
        login(user.getLogin(), user.getPassword());
    }

}
