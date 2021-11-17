package at.study.redmine.ui.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.redmine.cucumber.ElementName;
import at.study.redmine.cucumber.PageName;
import at.study.redmine.ui.BrowserManager;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@PageName("Пользователи")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class UserTablePage extends Page {

    @ElementName("Даты создания")
    @FindBy(xpath = "//table[@class='list users']/tbody//td[@class='created_on']")
    public List<WebElement> creationDates;

    @ElementName("Создано")
    @FindBy(xpath = "//th[@title='Сортировать по \"Создано\"']/a")
    public WebElement creationDateButton;

    public WebElement button(String text) {
        return BrowserManager.getBrowser().getDriver().findElement(By.xpath("//table[@class='list users']/thead//th[.='" + text + "']"));
    }
}
