package co.com.test.stepdefinitions.saucedemo;

import co.com.test.steps.CompraDeProductosSteps;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class CompraDeProductosStepDefinition {
    @Steps
    CompraDeProductosSteps compraDeProductosSteps;

    @When("agrega dos productos al carrito")
    public void agregaDosProductosAlCarrito() throws InterruptedException {
        compraDeProductosSteps.agregaDosProductosAlCarrito();
    }
    @When("procede al checkout completando la información requerida")
    public void procedeAlCheckoutCompletandoLaInformaciónRequerida() {
        compraDeProductosSteps.procedeAlCheckoutCompletandoLaInformaciónRequerida();
    }
    @Then("debe visualizar el mensaje de confirmación {string}")
    public void debeVisualizarElMensajeDeConfirmación(String mensaje) {
        compraDeProductosSteps.debeVisualizarElMensajeDeConfirmación(mensaje);
    }


}
