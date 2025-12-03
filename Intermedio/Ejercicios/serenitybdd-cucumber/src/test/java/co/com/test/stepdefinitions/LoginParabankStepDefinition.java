package co.com.test.stepdefinitions;

import co.com.test.steps.LoginParabankSteps;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.thucydides.core.annotations.Steps;

public class LoginParabankStepDefinition {
    @Steps
    LoginParabankSteps loginParabankSteps;

    @Given("que el usuario esta en la pagina de login de Parabank")
    public void queElUsuarioEstaEnLaPaginaDeLoginDeParabank() {
        loginParabankSteps.abrirPaginaDeLoginDeParabank();
    }

    @When("el usuario ingresa sus credenciales")
    public void elUsuarioIngresaSusCredenciales() {

    }

    @Then("el usuario es redirigido a la pagina de bienvenida")
    public void elUsuarioEsRedirigidoALaPaginaDeBienvenida() {

    }


}
