package co.com.test.steps;

import co.com.test.pages.LoginParabankPage;
import net.thucydides.core.annotations.Step;

public class LoginParabankSteps {
    LoginParabankPage loginParabankPage;

    @Step
    public void abrirPaginaDeLoginDeParabank() {
        loginParabankPage.open();
    }

    @Step
    public void ingresarCredencialesDeLoguin() {
        loginParabankPage.ingresarCredencialesDeLoguin();
    }

    @Step
    public void elUsuarioEsRedirigidoALaPaginaDeBienvenida() {
        loginParabankPage.elUsuarioEsRedirigidoALaPaginaDeBienvenida();
    }

    @Step
    public void accederConLasCredenciales(String user, String password) {
        loginParabankPage.accederConLasCredenciales(user, password);
    }

    public void elUsuarioVisualizaElMensajeDeBienvenida(String mensaje) {
        loginParabankPage.elUsuarioVisualizaElMensajeDeBienvenida(mensaje);
    }
}
