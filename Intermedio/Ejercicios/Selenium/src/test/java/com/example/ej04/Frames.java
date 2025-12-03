package com.example.ej04;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.example.Constantes.URL_FRAME;
import static com.example.Utilidades.esperar;

public class Frames {
    private WebDriver driver;
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
    public void testSingleIframe() throws Exception {
        driver.get(URL_FRAME);
        driver.switchTo().frame("SingleFrame");
        esperar(2);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hola");
        esperar(3);
    }

    @Test
    public void testIframeAnidado() throws Exception {
        driver.get(URL_FRAME);
        driver.findElement(By.xpath("//a[@href='#Multiple']")).click();
        driver.switchTo().frame(driver.findElement(By.xpath("//*[@id='Multiple']/iframe")));
        esperar(2);
        driver.switchTo().frame(driver.findElement(By.xpath("/html/body/section/div/div/iframe")));
        esperar(2);
        driver.findElement(By.xpath("//input[@type='text']")).sendKeys("Hola");
        esperar(3);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }

    private boolean isElementPresent(By by) {
        try {
            driver.findElement(by);
            return true;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

}
