package steps;

import at.study.redmine.allure.asserts.AllureAssert;
import at.study.redmine.ui.pages.HeaderPage;
import cucumber.api.java.ru.То;

import static at.study.redmine.ui.pages.Page.getPage;

public class AssertionSteps {

    @То("Текст элемента моей учетной записи - {string}")
    public void assertMyAccountText(String expectedText) {
        String actualText = getPage(HeaderPage.class).myAccount.getText();
        AllureAssert.assertEquals(actualText, expectedText, "Проверка текста элемента моей учетной записи");
    }

}
