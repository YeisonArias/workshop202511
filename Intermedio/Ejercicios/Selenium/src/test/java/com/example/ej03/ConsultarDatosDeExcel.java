package com.example.ej03;

import com.codoid.products.exception.FilloException;
import com.codoid.products.fillo.Recordset;
import com.example.ExcelManager;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import static com.example.Constantes.RUTA_ARCHIVO_EXCEL;
import static com.example.Utilidades.esperar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class ConsultarDatosDeExcel {
    private WebDriver driver;
    private String baseUrl;
    private ExcelManager excelManager;
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
        excelManager = new ExcelManager();
    }

    @Test
    public void testRegistroExitoso() throws FilloException, IOException {
        excelManager.strRutaArchivo(RUTA_ARCHIVO_EXCEL);
        String strQuery = "SELECT * FROM Hoja1";
        Recordset recordSet = excelManager.leerExcel(strQuery);
        System.out.println("Número de registro: "+recordSet.getCount());


        while (recordSet.next()) {
            esperar(2);
            driver.get("https://parabank.parasoft.com/parabank/register.htm");
            driver.findElement(By.id("customer.firstName")).sendKeys(recordSet.getField("fisrtname"));
            driver.findElement(By.id("customer.lastName")).sendKeys(recordSet.getField("lastname"));
            driver.findElement(By.id("customer.address.street")).sendKeys(recordSet.getField("address"));
            driver.findElement(By.id("customer.address.city")).sendKeys(recordSet.getField("city"));
            driver.findElement(By.id("customer.address.state")).sendKeys(recordSet.getField("state"));
            driver.findElement(By.id("customer.address.zipCode")).sendKeys(recordSet.getField("zipcode"));
            driver.findElement(By.id("customer.phoneNumber")).sendKeys(recordSet.getField("phone"));
            driver.findElement(By.id("customer.username")).sendKeys(recordSet.getField("user"));
            driver.findElement(By.id("customer.ssn")).sendKeys(recordSet.getField("ssn"));
            driver.findElement(By.id("customer.password")).sendKeys(recordSet.getField("password"));
            driver.findElement(By.id("repeatedPassword")).sendKeys(recordSet.getField("password"));
            {
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("src/test/resources/FormularioDiligenciado_"+recordSet.getField("user")+".png"));
            };
            driver.findElement(By.xpath("//input[@value='Register']")).click();
            {
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("src/test/resources/CreaciónExitosaDeUsuario_"+recordSet.getField("user")+".png"));
            };
            try {
                esperar(3);
                assertEquals("Your account was created successfully. You are now logged in.", driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText());
                esperar(3);

                strQuery ="UPDATE Hoja1 SET mensaje='OK:Se creo el usuario"+recordSet.getField("user")+"' WHERE id="+Integer.parseInt(recordSet.getField("id"));
                excelManager.ModificarRegistrosExcel(strQuery);

                driver.findElement(By.linkText("Log Out")).click();
                esperar(1);
            } catch (AssertionError e) {
                System.out.println("Error: " + e.getMessage());
                strQuery ="UPDATE Hoja1 SET mensaje='Error:No se logro el registro' WHERE id="+Integer.parseInt(recordSet.getField("id"));
                excelManager.ModificarRegistrosExcel(strQuery);
            }
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

