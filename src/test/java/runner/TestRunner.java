package runner;

import java.lang.reflect.Method;

import org.testng.ITest;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;

import at.study.redmine.context.Context;
import at.study.redmine.ui.BrowserManager;
import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;
import cucumber.api.testng.CucumberFeatureWrapper;
import cucumber.api.testng.PickleEventWrapper;

@CucumberOptions(
        plugin = {
                "pretty",
                "io.qameta.allure.cucumber4jvm.AllureCucumber4Jvm",
                "json:target/cucumber.json"
        },
        glue = {"steps"},
        features = "src/test/resources/features",
        tags = {"@ui"}
)
public class TestRunner extends AbstractTestNGCucumberTests implements ITest {

    @BeforeClass(alwaysRun = true)
    @Override
    public void setUpClass() throws Exception {
        super.setUpClass();
    }

    @Override
    public void runScenario(PickleEventWrapper pickleWrapper, CucumberFeatureWrapper featureWrapper) throws Throwable {
        super.runScenario(pickleWrapper, featureWrapper);
    }

    @DataProvider(parallel = true)
    @Override
    public Object[][] scenarios() {
        System.out.println("Total scenarions: " + super.scenarios().length);
        return super.scenarios();
    }

    @AfterClass(alwaysRun = true)
    @Override
    public void tearDownClass() throws Exception {
        super.tearDownClass();
    }

    @Override
    public String getTestName() {
        return null;
    }

    @BeforeMethod
    public void beforeMethod(Method name, Object[] testData) {

    }

    @AfterMethod(alwaysRun = true)
    public void afterMethod(Method name, Object[] testData) {
        Context.clearStash();
        BrowserManager.removeBrowser();
    }
}
