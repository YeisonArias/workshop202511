package co.com.test.steps;

import co.com.test.pages.LoginParabankPage;
import net.thucydides.core.annotations.Step;

public class LoginParabankSteps {
    LoginParabankPage loginParabankPage;

    @Step
    public void abrirPaginaDeLoginDeParabank() {
        loginParabankPage.open();
    }
}
