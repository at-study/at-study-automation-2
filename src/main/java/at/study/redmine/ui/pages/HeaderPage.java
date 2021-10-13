package at.study.redmine.ui.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import at.study.redmine.ui.BrowserManager;

public class HeaderPage extends Page {

    private WebElement homePage;

    private WebElement myPage;

    private WebElement projects;

    private WebElement administration;

    private WebElement help;

    @FindBy(xpath = "//div[@id='account']//a[@class='login']")
    public WebElement loginButton;

    @FindBy(xpath = "//div[@id='account']//a[@class='my-account']")
    public WebElement myAccount;

    public HeaderPage() {
        PageFactory.initElements(BrowserManager.getBrowser().getDriver(), this);
    }
}
