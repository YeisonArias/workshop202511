package co.com.test.steps;

import co.com.test.pages.CompraDeProductosPage;
import net.thucydides.core.annotations.Step;

public class CompraDeProductosSteps {
    CompraDeProductosPage compraDeProductosPage;

    @Step
    public void agregaDosProductosAlCarrito() throws InterruptedException {
        compraDeProductosPage.agregarProductoAlCarrito();
    }

    @Step
    public void procedeAlCheckoutCompletandoLaInformaciónRequerida() {
        compraDeProductosPage.procedeAlCheckoutCompletandoLaInformaciónRequerida();
    }

    @Step
    public void debeVisualizarElMensajeDeConfirmación(String mensaje) {
        compraDeProductosPage.debeVisualizarElMensajeDeConfirmación(mensaje);
    }
}
