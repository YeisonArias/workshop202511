package co.com.test.stepdefinitions;

import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // Configuración personalizada del WebDriver
        WebDriverManager.chromedriver().setup();

    }
}
