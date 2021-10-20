package at.study.redmine.ui;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

import at.study.redmine.property.Property;
import lombok.Getter;

@Getter
public class Browser {

    private WebDriver driver;
    private WebDriverWait wait;

    Browser() {
        this("");
    }

    Browser(String uri) {
        driver = DriverFactory.getDriver();
        driver.manage().window().maximize();
        int timeout = Property.getIntegerProperty("element.timeout");
        driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, timeout);
        get(uri);
    }

    public void get() {
        get("");
    }

    public void get(String uri) {
        getDriver().get(Property.getStringProperty("url") + uri);
    }

    public byte[] takeScreenshot() {
        return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
    }

    public void executeJavaScript(String js, Object... args) {
        ((JavascriptExecutor) driver).executeScript(js, args);
    }

    public Actions actions() {
        return new Actions(driver);
    }

}
