package co.com.test.runners;

import io.cucumber.junit.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(
        features = "src/test/resources/features/login_parabank.feature",
        glue = "co.com.test.stepdefinitions",
        snippets = CucumberOptions.SnippetType.CAMELCASE,
        tags = "@Test",
        plugin = {
                "pretty",
                "json:target/cucumber-report/cucumber.json"
        }
)
public class Runner {
}
