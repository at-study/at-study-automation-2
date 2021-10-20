package at.tests.ui;

import org.testng.annotations.AfterMethod;

import at.study.redmine.ui.Browser;
import at.study.redmine.ui.BrowserManager;
import at.study.redmine.ui.pages.AdministrationPage;
import at.study.redmine.ui.pages.HeaderPage;
import at.study.redmine.ui.pages.LoginPage;
import at.study.redmine.ui.pages.UserTablePage;

import static at.study.redmine.ui.pages.Page.getPage;

public class BaseUITest {

    protected Browser browser;
    protected HeaderPage headerPage;
    protected LoginPage loginPage;
    protected AdministrationPage administrationPage;
    protected UserTablePage userTablePage;

    protected void openBrowser() {
        browser = BrowserManager.getBrowser();
        headerPage = getPage(HeaderPage.class);
        loginPage = getPage(LoginPage.class);
        administrationPage = getPage(AdministrationPage.class);
        userTablePage = getPage(UserTablePage.class);
    }

    @AfterMethod
    public void tearDown() {
        BrowserManager.removeBrowser();
    }
}
