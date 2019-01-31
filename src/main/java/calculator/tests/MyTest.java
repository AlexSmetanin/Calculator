package calculator.tests;

import calculator.BaseTest;
import calculator.pages.LoginPage;
import org.openqa.selenium.support.events.EventFiringWebDriver;

public class MyTest extends BaseTest {

    public static void main(String[] args) {

        EventFiringWebDriver driver = getConfiguredDriver();

        LoginPage loginPage = new LoginPage(driver);

        loginPage.open();
        loginPage.readFile();
        /*loginPage.fillEmailInput();
        loginPage.fillPasswordInput();
        loginPage.clickLoginButton();

        DashboardPage dashboardPage = new DashboardPage(driver);

        dashboardPage.selectOrdersItem();
        dashboardPage.addNewCategory("Men");
        dashboardPage.filterCategory("Men");

        quitDriver(driver);*/
    }
}