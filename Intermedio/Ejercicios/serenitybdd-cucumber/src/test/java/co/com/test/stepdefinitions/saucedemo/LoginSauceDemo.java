package co.com.test.stepdefinitions.saucedemo;

import co.com.test.steps.LoginSauceDemoSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.thucydides.core.annotations.Steps;

public class LoginSauceDemo {
    @Steps
    LoginSauceDemoSteps loginSauceDemoSteps;

    @Given("que el usuario esta en la pagina de login de SauceDemo")
    public void queElUsuarioEstaEnLaPaginaDeLoginDeSauceDemo() {
        loginSauceDemoSteps.abrirPaginaDeLoginDeSauceDemo();
    }

    @When("el usuario ingresa las credenciales")
    public void elUsuarioIngresaLasCredenciales() throws InterruptedException {
        loginSauceDemoSteps.ingresarCredenciales();
    }

    @Then("el usuario es redirigido a la pagina de Swag Labs")
    public void elUsuarioEsRedirigidoALaPaginaDeSwagLabs() {
        loginSauceDemoSteps.elUsuarioEsRedirigidoALaPaginaDeSwagLabs();
    }


}
