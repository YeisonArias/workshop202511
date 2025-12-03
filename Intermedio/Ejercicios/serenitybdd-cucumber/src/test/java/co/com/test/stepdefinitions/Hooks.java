package co.com.test.stepdefinitions;


import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import java.time.Duration;
import static net.serenitybdd.core.Serenity.getDriver;

public class Hooks {

    @Before
    public void setUp() {
        // Configuración personalizada del WebDriver
        WebDriverManager.chromedriver().setup();
        getDriver().manage().window().maximize();
        getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }
}
