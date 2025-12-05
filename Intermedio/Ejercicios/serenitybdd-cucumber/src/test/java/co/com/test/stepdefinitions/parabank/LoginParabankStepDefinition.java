package co.com.test.stepdefinitions.parabank;

import co.com.test.steps.LoginParabankSteps;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
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
        loginParabankSteps.ingresarCredencialesDeLoguin();
    }

    @Then("el usuario es redirigido a la pagina de bienvenida")
    public void elUsuarioEsRedirigidoALaPaginaDeBienvenida() {
        loginParabankSteps.elUsuarioEsRedirigidoALaPaginaDeBienvenida();
    }

    @When("el usuario el usuario {string} y la clave {string}")
    public void elUsuarioElUsuarioYLaClave(String user, String password) {
        loginParabankSteps.accederConLasCredenciales(user, password);
    }
    @Then("el usuario visualiza el mensaje de bienvenida {string}")
    public void elUsuarioVisualizaElMensajeDeBienvenida(String mensaje) {
        loginParabankSteps.elUsuarioVisualizaElMensajeDeBienvenida(mensaje);
    }






}
