package com.example.ej02;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.time.Duration;

import static com.example.Constantes.PASSWORD;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Registro {
    private WebDriver driver;
    private String baseUrl;
    private boolean acceptNextAlert = true;
    private StringBuffer verificationErrors = new StringBuffer();
    JavascriptExecutor js;
    @Before
    public void setUp() throws Exception {
        //System.setProperty("webdriver.chrome.driver", "");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testRegistroExitoso() throws Exception {
        //ERROR: Caught exception [ERROR: Unsupported command [loadVars | data.csv | ]]
        driver.get("https://parabank.parasoft.com/parabank/register.htm");
        driver.findElement(By.id("customer.firstName")).sendKeys("${firstName}");
        driver.findElement(By.id("customer.lastName")).sendKeys("${lastName}");
        driver.findElement(By.id("customer.address.street")).sendKeys("Calle 1 #1-4");
        driver.findElement(By.id("customer.address.city")).sendKeys("Medellin");
        driver.findElement(By.id("customer.address.state")).click();
        driver.findElement(By.id("customer.address.state")).sendKeys("Antioquia");
        driver.findElement(By.id("customer.address.zipCode")).sendKeys("05001");
        driver.findElement(By.id("customer.phoneNumber")).sendKeys("2222222");
        driver.findElement(By.id("customer.username")).sendKeys("yarias15");
        driver.findElement(By.id("customer.ssn")).sendKeys("123456");
        driver.findElement(By.id("customer.password")).clear();
        driver.findElement(By.id("customer.password")).sendKeys(PASSWORD);
        driver.findElement(By.id("repeatedPassword")).sendKeys(PASSWORD);
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/FormularioDiligenciado.png"));
        };
        driver.findElement(By.xpath("//input[@value='Register']")).click();
        driver.findElement(By.xpath("//div[@id='rightPanel']/p")).click();
        {
            File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            FileUtils.copyFile(scrFile, new File("src/test/resources/CreaciónExitosaDeUsuario.png"));
        };
        try {
            assertEquals("Your account was created successfully. You are now logged in.", driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
        driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/ul/li[8]/a")).click();
        //ERROR: Caught exception [ERROR: Unsupported command [endLoadVars |  | ]]
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
        String verificationErrorString = verificationErrors.toString();
        if (!"".equals(verificationErrorString)) {
            fail(verificationErrorString);
        }
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    private boolean isAlertPresent() {
        try {
            driver.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }

    private String closeAlertAndGetItsText() {
        try {
            Alert alert = driver.switchTo().alert();
            String alertText = alert.getText();
            if (acceptNextAlert) {
                alert.accept();
            } else {
                alert.dismiss();
            }
            return alertText;
        } finally {
            acceptNextAlert = true;
        }
    }
}
