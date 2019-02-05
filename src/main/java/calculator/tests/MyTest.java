package calculator.tests;

import calculator.BaseTest;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyTest extends BaseTest {

    public static void main(String[] args) {

        EventFiringWebDriver driver = getConfiguredDriver();

        Calculator calculator = new Calculator(driver);

        calculator.open();
        calculator.standardTest();
        calculator.scienceTest();
        calculator.getResult();
        quitDriver(driver);
    }
}