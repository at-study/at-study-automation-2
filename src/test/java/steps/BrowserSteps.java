package steps;

import at.study.redmine.ui.BrowserManager;
import cucumber.api.java.ru.И;

public class BrowserSteps {

    @И("Открыт браузер на главной странице")
    public void openBrowserOnMainPage() {
        BrowserManager.getBrowser();
    }

    @И("Открыт браузер на странице {string}")
    public void openBrowserOnPage(String url) {
        BrowserManager.getBrowser(url);
    }

}
