package com.example.ej07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

import static com.example.Constantes.URL_TABLAS;
import static com.example.Constantes.URL_WINDOWS;
import static com.example.Utilidades.esperar;

public class Tablas {
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
    public void testTablas()  {
        driver.get(URL_TABLAS);

        List columnas = driver.findElements(By.xpath("//table/thead/tr/th"));
        System.out.println("La cantidad de Columnas de la tabla es: "+columnas.size());

        List filas = driver.findElements(By.xpath("//table/tbody/tr"));
        System.out.println("La cantidad de Filas de la tabla es: "+filas.size());
    }

    @Test
    public void valoresTabla()  {
        driver.get(URL_TABLAS);

        WebElement tabla = driver.findElement(By.xpath("//table[@class='dataTable']"));

        WebElement fila = tabla.findElement(By.xpath("//tbody/tr[2]"));

        WebElement celda = tabla.findElement(By.xpath("//tbody/tr[2]/td[3]"));

        System.out.println("los datos de la fila 2 es: "+fila.getText());
        System.out.println("los datos de la celda 3 es: "+celda.getText());

        esperar(10);

    }


    @Test
    public void imprimirValoresTabla()  {
        driver.get(URL_TABLAS);

        WebElement tabla = driver.findElement(By.xpath("//table[@class='dataTable']"));

        List company = tabla.findElements(By.xpath("//table[@class='dataTable']/tbody/tr/td[1]"));

        for (int i = 0; i < company.size(); i++) {
            System.out.println("La empresa número:"+ (i+1)+" - " +
                    tabla.findElement(By.xpath("//tbody/tr["+(i+1)+"]/td[1]")).getText());
            System.out.println("--------------------------------------------");
        }
        esperar(30);

    }

    @After
    public void tearDown() throws Exception {
        driver.quit();
    }



}
