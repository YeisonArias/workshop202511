package com.example.ej06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.example.Constantes.URL_WINDOWS;
import static com.example.Utilidades.esperar;

public class Ventanas {
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
    public void testAlertWithOk() throws Exception {
        driver.get(URL_WINDOWS);
        System.out.println(driver.getWindowHandle());

        String mainWindow = driver.getWindowHandle();

        driver.findElement(By.xpath("//*[@id='Tabbed']/a/button")).click();
        for(String windowHandle : driver.getWindowHandles()){
            esperar(1);
            driver.switchTo().window(windowHandle);
            System.out.println("Ventana: "+ driver.getTitle());
        }
        esperar(2);
        driver.switchTo().window(mainWindow);
        esperar(2);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}
