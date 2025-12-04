package co.com.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;

import static org.junit.Assert.assertEquals;


@DefaultUrl("https://para.testar.org/parabank/index.htm")
public class LoginParabankPage extends PageObject {
    //Locators LOGIN
    @FindBy(name="username")
    private WebElementFacade USERNAME;
    @FindBy(name="password")
    private WebElementFacade PASSWORD;
    @FindBy(xpath="//input[@value='Log In']")
    private WebElementFacade BTN_LOG_IN;

    //Locators BIENVENIDA
    @FindBy(xpath="//p[@class='smallText']")
    private WebElementFacade BIENVENIDA;

    //Locators Log Out
    @FindBy(linkText="Log Out")
    private WebElementFacade LOG_OUT;

    //Methods
    public void ingresarCredencialesDeLoguin() {
        USERNAME.sendKeys("john");
        PASSWORD.sendKeys("demo");
        BTN_LOG_IN.click();
    }

    public void elUsuarioEsRedirigidoALaPaginaDeBienvenida() {
        String bienvenida = "Welcome";
        assertEquals(bienvenida, BIENVENIDA.getText());
        LOG_OUT.click();
    }

    public void accederConLasCredenciales(String user, String password) {
        USERNAME.sendKeys(user);
        PASSWORD.sendKeys(password);
        BTN_LOG_IN.click();
    }

    public void elUsuarioVisualizaElMensajeDeBienvenida(String mensaje) {
        assertEquals(mensaje, BIENVENIDA.getText());
        LOG_OUT.click();
    }
}
