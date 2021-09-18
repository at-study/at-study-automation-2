package testng_explanation;

import java.util.Random;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import testng_examples.Calculator;

public class MySecondTest {

    private int random1;
    private int random2;

    @BeforeMethod
    public void prepareFixture() {
        random1 = new Random().nextInt(50);
        random2 = new Random().nextInt(30);
    }

    @Test
    public void subtractCalculationTest() {
        int actual = Calculator.subtract(random1, random2);
        int expected = random1 - random2;

        Assert.assertEquals(actual, expected);
    }

}
