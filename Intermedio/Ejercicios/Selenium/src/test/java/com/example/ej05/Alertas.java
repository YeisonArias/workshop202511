package com.example.ej05;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

import static com.example.Constantes.URL_ALERTAS;
import static com.example.Utilidades.esperar;

public class Alertas {
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
        driver.get(URL_ALERTAS);
        //Botón Alerta
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        //Gestionar Alerta
        Alert alerta = driver.switchTo().alert();
        System.out.println(alerta.getText());
        esperar(2);
        alerta.accept();
        esperar(2);
    }

    @Test
    public void testAlertWithOkCancel() throws Exception {
        driver.get(URL_ALERTAS);
        //Boton Sección Alerta OK/Cancel
        driver.findElement(By.xpath("//a[@href='#CancelTab']")).click();
        //Botón Alerta
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //Gestionar Alerta OK
        Alert alerta = driver.switchTo().alert();
        System.out.println(alerta.getText());
        esperar(2);
        alerta.accept();
        esperar(2);

        //Botón Alerta
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();

        //Gestionar Alerta Cancel
        Alert alertaCancel = driver.switchTo().alert();
        System.out.println(alertaCancel.getText());
        esperar(2);
        alertaCancel.dismiss();
        esperar(2);
    }

    @Test
    public void testAlertWithTextbox() throws Exception {
        driver.get(URL_ALERTAS);
        //Boton Sección Alerta Textbox
        driver.findElement(By.xpath("//a[@href='#Textbox']")).click();
        //Botón Alerta
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        //Gestionar Alerta OK
        Alert alerta = driver.switchTo().alert();
        System.out.println(alerta.getText());
        esperar(2);
        alerta.sendKeys("Alerta con Mensaje");
        esperar(2);
        alerta.accept();
        esperar(2);
    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}
