package co.com.test.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

import static org.junit.Assert.assertEquals;

public class CompraDeProductosPage extends PageObject {
    @FindBy(id="add-to-cart-sauce-labs-backpack")
    private WebElementFacade ARTICULO_BACKPACK;
    @FindBy(id="add-to-cart-sauce-labs-bike-light")
    private WebElementFacade ARTICULO_BIKE_LIGHT;
    @FindBy(xpath="//a[@class='shopping_cart_link']")
    private WebElementFacade CARRITO;

    //Checkout
    @FindBy(id="checkout")
    private WebElementFacade CHECKOUT;
    @FindBy(id="first-name")
    private WebElementFacade NOMBRE;
    @FindBy(id="last-name")
    private WebElementFacade APELLIDO;
    @FindBy(id="postal-code")
    private WebElementFacade CODIGO_POSTAL;
    @FindBy(id="continue")
    private WebElementFacade CONTINUAR;
    @FindBy(id="finish")
    private WebElementFacade FINALIZAR;

    //Confirmacion
    @FindBy(xpath="//h2[@class='complete-header']")
    private WebElementFacade MENSAJE_COMFIRMACION;


    public void agregarProductoAlCarrito() throws InterruptedException {
        Thread.sleep(3000);
        ARTICULO_BACKPACK.click();
        ARTICULO_BIKE_LIGHT.click();
        CARRITO.click();
    }

    public void procedeAlCheckoutCompletandoLaInformaciónRequerida() {
        CHECKOUT.click();
        NOMBRE.sendKeys("Juan");
        APELLIDO.sendKeys("Perez");
        CODIGO_POSTAL.sendKeys("12345");
        CONTINUAR.click();
        FINALIZAR.click();
    }

    public void debeVisualizarElMensajeDeConfirmación(String mensaje) {
        assertEquals(mensaje, MENSAJE_COMFIRMACION.getText());
    }
}
