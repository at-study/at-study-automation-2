package steps;

import at.study.redmine.ui.pages.HeaderPage;
import cucumber.api.java.ru.Если;

import static at.study.redmine.ui.pages.Page.getPage;

public class UiSteps {

    @Если("Нажать кнопку Войти")
    public void clickOnLoginButton() {
        getPage(HeaderPage.class).loginButton.click();
    }


}
