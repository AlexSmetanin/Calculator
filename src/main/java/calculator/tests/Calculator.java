package calculator.tests;

import calculator.utils.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.support.events.EventFiringWebDriver;

import java.io.FileWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.io.IOException;

public class Calculator {
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
    private By resultTxtArea= By.className("paskatxt");                     // result text area
    private By switchModeLnk= By.id("prepc");                               // switch calcualator standart/scientific mode
    private By sqrtBtn      = By.xpath("//*[@id='advcalcbox']/div[4]/a");   // Square root of x
    private By powerBtn     = By.xpath("//*[@id='advcalcbox']/div[5]/a");   // x raised to the power of y
    private By sqrBtn       = By.xpath("//*[@id='advcalcbox']/div[6]/a");   // x squared


    public Calculator(EventFiringWebDriver driver){
        this.driver = driver;
    }

    public void open(){
        driver.get(Properties.getBaseUrl());
    }

    // Start test for standard calculator mode
    public void standardTest() {
        readFile("/test.txt");
    }

    // Start test for scientific calculator mode
    public void scienceTest(){
        checkMode();
        readFile("/test2.txt");
    }

    // Check the calculator mode
    public void checkMode() {
        if (driver.findElement(switchModeLnk).getText() == "scientific calculator"){    // if the 'standard calculator' mode is on,
            driver.findElement(switchModeLnk).click();                                  // that click the 'scientific calculator' link
        }
    }

    // Read the test file
    public void readFile(String FileName) {
        List<String> lines = null;
        try {
            lines = Files.readAllLines(Paths.get(FileName), StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        for(String line: lines){
            readString(line);
        }
    }

    // Read lines from test file
    public void readString(String line) {
        int length = line.length();
        for (int i = 0; i < length; ++i) {
            readChar(line.charAt(i));
        }
        driver.findElement(equalBtn).click();
    }

    // Recognize char and press button
    public void readChar(char currentChat) {
        switch (currentChat) {
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
            case '^':
                driver.findElement(powerBtn).click();
                break;
            default:
                break;
        }
    }

    // Get result from TextArea and write it to rerult.txt file
    public void getResult() {
        String resultText = driver.findElement(resultTxtArea).getAttribute("value");
        try (FileWriter writer = new FileWriter("result.txt",false)) {
            writer.write(resultText);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
}
