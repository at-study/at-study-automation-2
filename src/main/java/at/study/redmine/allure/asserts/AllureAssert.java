package at.study.redmine.allure.asserts;

import org.testng.Assert;

import io.qameta.allure.Step;

public class AllureAssert {

    @Step("Проверка равенства: {2}")
    public static void assertEquals(Object actual, Object expected, String message) {
        Assert.assertEquals(actual, expected, message);
    }

    @Step("Проверка равенства")
    public static void assertEquals(Object actual, Object expected) {
        Assert.assertEquals(actual, expected);
    }

}
