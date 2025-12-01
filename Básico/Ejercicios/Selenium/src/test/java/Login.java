import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

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
        System.setProperty("webdriver.chrome.driver", "C:\\WS JAVA\\202511\\Básico\\Ejercicios\\Selenium\\src\\test\\resources\\drivers\\chromedriver.exe");
        driver = new ChromeDriver();
        baseUrl = "https://www.google.com/";
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        js = (JavascriptExecutor) driver;
    }

    @Test
    public void testLogin() throws Exception {
        driver.get("https://parabank.parasoft.com/parabank/index.htm?ConnType=JDBC");
        driver.findElement(By.name("username")).click();
        driver.findElement(By.name("username")).clear();
        driver.findElement(By.name("username")).sendKeys("yfarias8");
        driver.findElement(By.name("password")).click();
        driver.findElement(By.name("password")).clear();
        driver.findElement(By.name("password")).sendKeys("1234");
        driver.findElement(By.xpath("//input[@value='Log In']")).click();
        driver.get("https://parabank.parasoft.com/parabank/overview.htm");
        driver.findElement(By.xpath("//div[@id='leftPanel']/p")).click();
        try {
            assertEquals("Welcome Yeison Arias", driver.findElement(By.xpath("//div[@id='leftPanel']/p")).getText());
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
