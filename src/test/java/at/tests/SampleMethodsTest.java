package at.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

public class SampleMethodsTest {

    @Test
    public void positiveTest() {

    }

    @Test
    public void assertFailTest() {
        Assert.assertEquals(3, 5);
    }

    @Test
    public void throwExceptionTest() {
        throw new IllegalArgumentException("Текст исключения");
    }

}
