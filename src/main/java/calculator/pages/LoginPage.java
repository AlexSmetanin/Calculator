package calculator.pages;

import calculator.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class LoginPage {
    private EventFiringWebDriver driver;

    private By number0Btn   = By.id("btn96");
    private By number1Btn   = By.id("btn97");
    private By number2Btn   = By.id("btn98");
    private By number3Btn   = By.id("btn99");
    private By number4Btn   = By.id("btn100");
    private By number5Btn   = By.id("btn101");
    private By number6Btn   = By.id("btn102");
    private By number7Btn   = By.id("btn103");
    private By number8Btn   = By.id("btn104");
    private By number9Btn   = By.id("btn105");
    private By pointBtn     = By.id("btn110");
    private By plusBtn      = By.id("btn107");
    private By minusBtn     = By.id("btn109");
    private By asteriksBtn  = By.id("btn106");
    private By divisionBtn  = By.id("btn111");
    private By equalBtn     = By.id("btn13");

    public LoginPage(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(Properties.getBaseUrl());
    }

    public void readFile() {
        String FILE_NAME = "d:\\test.txt";
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(FILE_NAME), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String line: lines){
            readString(line);
        }
    }

    public void readString(String line) {
        int length = line.length();
        for (int i = 0; i < length; ++i) {
            switch (line.charAt(i)) {
                case '1':
                    driver.findElement(number1Btn).click();
                    break;
                case '2':
                    driver.findElement(number2Btn).click();
                    break;
                case '3':
                    driver.findElement(number3Btn).click();
                    break;
                case '4':
                    driver.findElement(number4Btn).click();
                    break;
                case '5':
                    driver.findElement(number5Btn).click();
                    break;
                case '6':
                    driver.findElement(number6Btn).click();
                    break;
                case '7':
                    driver.findElement(number7Btn).click();
                    break;
                case '8':
                    driver.findElement(number8Btn).click();
                    break;
                case '9':
                    driver.findElement(number9Btn).click();
                    break;
                case '0':
                    driver.findElement(number0Btn).click();
                    break;
                case '+':
                    driver.findElement(plusBtn).click();
                    break;
                case '-':
                    driver.findElement(minusBtn).click();
                    break;
                case '*':
                    driver.findElement(asteriksBtn).click();
                    break;
                case '/':
                    driver.findElement(divisionBtn).click();
                    break;
                case '.':
                    driver.findElement(pointBtn).click();
                    break;
                default:
                    break;
            }
        }
        driver.findElement(equalBtn).click();
    }
    /*public void fillEmailInput(){
        driver.findElement(emailInput).sendKeys(email);
    }

    public void fillPasswordInput(){
        driver.findElement(passwordInput).sendKeys(password);
    }

    public void clickLoginButton(){
        driver.findElement(loginBtn).click();
    }*/
}
