package steps;

import at.study.redmine.context.Context;
import at.study.redmine.model.User;
import at.study.redmine.ui.pages.LoginPage;
import cucumber.api.java.ru.И;

import static at.study.redmine.ui.pages.Page.getPage;

public class AuthorizationSteps {

    @И("Войти в систему под пользователем {string}")
    public void loginAsUser(String userStashId) {
        User user = Context.getStash().get(userStashId, User.class);
        getPage(LoginPage.class).login(user);
    }

    @И("Войти в систему с логином {string} и паролем {string}")
    public void loginByUserNameAndPassword(String login, String password) {
        getPage(LoginPage.class).login(login, password);
    }

}
