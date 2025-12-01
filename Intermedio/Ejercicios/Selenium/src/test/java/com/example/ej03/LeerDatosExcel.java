package com.example.ej03;

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
import java.time.Duration;

import static com.example.Constantes.PASSWORD;
import static com.example.Constantes.RUTA_ARCHIVO_EXCEL;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class LeerDatosExcel {
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
        String rutaArchivo = RUTA_ARCHIVO_EXCEL;
        FileInputStream file = new FileInputStream(rutaArchivo);
        Workbook workbook = new XSSFWorkbook(file); //Toma el libro del archivo
        Sheet sheet = workbook.getSheetAt(0); //Definir la hoja 1 de mi archivo de excel
        int numeroFilas = sheet.getLastRowNum();

        System.out.println("numeroFilas: " + numeroFilas);
        DataFormatter formatter = new DataFormatter();

        for (int i = 0; i < numeroFilas; i++) {
            Row fila = sheet.getRow(i+1);
            driver.get("https://parabank.parasoft.com/parabank/register.htm");
            driver.findElement(By.id("customer.firstName")).sendKeys(formatter.formatCellValue(fila.getCell(1)));
            driver.findElement(By.id("customer.lastName")).sendKeys(formatter.formatCellValue(fila.getCell(2)));
            driver.findElement(By.id("customer.address.street")).sendKeys(formatter.formatCellValue(fila.getCell(3)));
            driver.findElement(By.id("customer.address.city")).sendKeys(formatter.formatCellValue(fila.getCell(4)));
            driver.findElement(By.id("customer.address.state")).sendKeys(formatter.formatCellValue(fila.getCell(5)));
            driver.findElement(By.id("customer.address.zipCode")).sendKeys(formatter.formatCellValue(fila.getCell(6)));
            driver.findElement(By.id("customer.phoneNumber")).sendKeys(formatter.formatCellValue(fila.getCell(7)));
            driver.findElement(By.id("customer.username")).sendKeys(formatter.formatCellValue(fila.getCell(9)));
            driver.findElement(By.id("customer.ssn")).sendKeys(formatter.formatCellValue(fila.getCell(8)));
            driver.findElement(By.id("customer.password")).sendKeys(formatter.formatCellValue(fila.getCell(10)));
            driver.findElement(By.id("repeatedPassword")).sendKeys(formatter.formatCellValue(fila.getCell(10)));
            {
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("src/test/resources/FormularioDiligenciado.png"));
            };
            driver.findElement(By.xpath("//input[@value='Register']")).click();
            {
                File scrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
                FileUtils.copyFile(scrFile, new File("src/test/resources/CreaciónExitosaDeUsuario.png"));
            };
            try {
                assertEquals("Your account was created successfully. You are now logged in.", driver.findElement(By.xpath("//div[@id='rightPanel']/p")).getText());
            } catch (Error e) {
                verificationErrors.append(e.toString());
            }
            driver.findElement(By.linkText("Log Out")).click();
        }
        workbook.close();
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
