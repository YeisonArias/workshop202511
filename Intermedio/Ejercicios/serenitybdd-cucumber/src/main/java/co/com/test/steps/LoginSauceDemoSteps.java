package co.com.test.steps;

import co.com.test.pages.LoginSauceDemoPage;
import net.thucydides.core.annotations.Step;

public class LoginSauceDemoSteps {
    LoginSauceDemoPage loginSauceDemoPage;

    @Step
    public void abrirPaginaDeLoginDeSauceDemo() {
        loginSauceDemoPage.open();
    }

    @Step
    public void ingresarCredenciales() throws InterruptedException {
        loginSauceDemoPage.ingresarCredenciales();
    }

    @Step
    public void elUsuarioEsRedirigidoALaPaginaDeSwagLabs() {
        loginSauceDemoPage.elUsuarioEsRedirigidoALaPaginaDeSwagLabs();
    }
}
