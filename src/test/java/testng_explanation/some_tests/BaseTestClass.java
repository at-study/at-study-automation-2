package testng_explanation.some_tests;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

public class BaseTestClass {

    @BeforeSuite
    public void beforeSuite() {
        System.out.println("Before Suite Method");
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("Before Class Method");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Before Method Method");
    }

    @AfterSuite
    public void afterSuite() {
        System.out.println("After Suite Method");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("After Class Method");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("After Method Method");
    }

}
