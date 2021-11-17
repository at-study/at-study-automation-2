package steps;

import java.util.List;

import org.openqa.selenium.WebElement;

import at.study.redmine.allure.asserts.AllureAssert;
import at.study.redmine.cucumber.PageObjectHelper;
import at.study.redmine.ui.pages.HeaderPage;
import cucumber.api.java.ru.Если;
import cucumber.api.java.ru.И;
import cucumber.api.java.ru.Тогда;

import static at.study.redmine.ui.BrowserUtils.getElementsText;
import static at.study.redmine.ui.pages.Page.getPage;
import static at.study.redmine.utils.CompareUtils.assertListSortedByDateDesc;

public class UiSteps {

    @Если("Нажать кнопку Войти")
    public void clickOnLoginButton() {
        getPage(HeaderPage.class).loginButton.click();
    }


    @Тогда("На странице {string} текст элемента {string} равен {string}")
    public void assertElementOnPageHasText(String pageName, String elementName, String expectedText) {
        String actualText = PageObjectHelper.findElement(pageName, elementName).getText();
        AllureAssert.assertEquals(actualText, expectedText);
    }

    @Если("На странице {string} нажать на элемент {string}")
    public void clickOnElementOnPage(String pageName, String elementName) {
        PageObjectHelper.findElement(pageName, elementName).click();
    }

    @И("На странице {string} в поле {string} ввести текст {string}")
    public void sendKeysOnElementOnPage(String pageName, String elementName, String charSequence) {
        PageObjectHelper.findElement(pageName, elementName).sendKeys(charSequence);
    }

    @И("На странице {string} тексты элементов {string} отсортированы по дате по убыванию")
    public void assertElementsTextsSortedByDateDesc(String pageName, String elementsName) {
        List<WebElement> dates = PageObjectHelper.findElements(pageName, elementsName);
        List<String> creationDatesByDesc = getElementsText(dates);
        assertListSortedByDateDesc(creationDatesByDesc);
    }
}
