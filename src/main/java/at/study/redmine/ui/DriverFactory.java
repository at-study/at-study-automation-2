package at.study.redmine.ui;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import at.study.redmine.property.Property;

public class DriverFactory {

    private static final String BROWSER_NAME = Property.getStringProperty("browser");

    static WebDriver getDriver() {
        switch (BROWSER_NAME) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/chromedriver.exe");
                return new ChromeDriver();
            case "firefox":
                System.setProperty("webdriver.gecko.driver", "src/test/resources/drivers/geckodriver.exe");
                return new FirefoxDriver();
            default:
                throw new IllegalArgumentException("Неизвестный браузер: " + BROWSER_NAME);
        }
    }

}
