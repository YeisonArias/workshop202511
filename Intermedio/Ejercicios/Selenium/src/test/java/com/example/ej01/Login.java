package com.example.ej01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.time.Duration;
import static com.example.Constantes.*;
import static com.example.Utilidades.esperar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class Login {
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
    public void testLoginExitoso() throws Exception {
        try {
        driver.get(URL);
        driver.findElement(By.name("username")).sendKeys(USUARIO);
        driver.findElement(By.name("password")).sendKeys(PASSWORD);
        driver.findElement(By.xpath("//input[@value='Log In']")).click();

        esperar(4);

        assertEquals(BIENVENIDA_LOGIN_EXITOSO, driver.findElement(By.xpath("//*[@id=\"leftPanel\"]/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
    }

    @Test
    public void testLoginFallidos() throws Exception {
        try {
            driver.get(baseUrl);
            driver.findElement(By.name("username")).sendKeys(USUARIO);
            driver.findElement(By.xpath("//input[@value='Log In']")).click();

            assertEquals(MENSAJE_PASSWORD_BLANCO, driver.findElement(By.xpath("//*[@id=\"rightPanel\"]/p")).getText());
        } catch (Error e) {
            verificationErrors.append(e.toString());
        }
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
