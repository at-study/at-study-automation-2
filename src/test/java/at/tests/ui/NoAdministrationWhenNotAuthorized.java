package at.tests.ui;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static at.study.redmine.ui.BrowserUtils.isElementCurrentlyDisplayed;

public class NoAdministrationWhenNotAuthorized extends BaseUITest {

    @BeforeMethod
    public void prepareFixtures() {
        openBrowser();
    }

    @Test
    public void testNoAdministrationWhenNotAuthorized() {
        Assert.assertFalse(isElementCurrentlyDisplayed(headerPage.administration));
    }

}
