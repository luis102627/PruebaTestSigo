package co.com.certificacion.falabella.runners;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src\\test\\resources\\features\\realizar_compra.feature",
        glue = "co.com.certificacion.falabella.stepdefinitions",
        snippets = SnippetType.CAMELCASE,
        tags = "")
public class RealizarCompraRunner {
}
