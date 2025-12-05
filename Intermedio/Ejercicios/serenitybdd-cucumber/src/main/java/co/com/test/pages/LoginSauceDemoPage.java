package co.com.test.pages;

import net.serenitybdd.core.Serenity;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import org.openqa.selenium.Alert;

import static org.junit.Assert.assertEquals;

@DefaultUrl("https://www.saucedemo.com")
public class LoginSauceDemoPage extends PageObject {
    @FindBy(id="user-name")
    private WebElementFacade USERNAME;

    @FindBy (id="password")
    private WebElementFacade PASSWORD;

    @FindBy (id="login-button")
    private WebElementFacade LOGIN_BUTTON;

    @FindBy (xpath="//div[@class='app_logo']")
    private WebElementFacade TITLE;


    public void ingresarCredenciales() throws InterruptedException {
        USERNAME.sendKeys("standard_user");
        PASSWORD.type("secret_sauce");
        LOGIN_BUTTON.click();
    }

    public void elUsuarioEsRedirigidoALaPaginaDeSwagLabs() {
        String tituloPagina = "Swag Labs";
        assertEquals(tituloPagina, TITLE.getText());
    }
}
