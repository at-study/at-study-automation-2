package at.study.redmine.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import at.study.redmine.cucumber.ElementName;
import at.study.redmine.cucumber.PageName;
import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@PageName("Заголовок страницы")
@NoArgsConstructor(access = AccessLevel.PACKAGE)
public class HeaderPage extends Page {

    @ElementName("Домашняя страница")
    private WebElement homePage;

    @ElementName("Моя страница")
    private WebElement myPage;

    @ElementName("Проекты")
    private WebElement projects;

    @ElementName("Администрирование")
    @FindBy(xpath = "//div[@id='top-menu']//a[@class='administration']")
    public WebElement administration;

    @ElementName("Помощь")
    @FindBy(xpath = "//div[@id='top-menu']//a[@class='help']")
    private WebElement help;

    @ElementName("Войти")
    @FindBy(xpath = "//div[@id='account']//a[@class='login']")
    public WebElement loginButton;

    @ElementName("Моя учётная запись")
    @FindBy(xpath = "//div[@id='account']//a[@class='my-account']")
    public WebElement myAccount;

}
