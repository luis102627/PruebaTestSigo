package co.com.certificacion.falabella.questions;

import co.com.certificacion.falabella.userinterfaces.Falabella;
import co.com.certificacion.falabella.utils.Constantes;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.WebDriver;

import static co.com.certificacion.falabella.userinterfaces.Falabella.*;
import static co.com.certificacion.falabella.utils.Constantes.*;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.*;

public class ValidarUrl implements Question {
    private WebDriver driver;
    @Override
    public Object answeredBy(Actor actor) {
        actor.attemptsTo(WaitUntil.the(LB_OPCIONES_DESPACHO, isVisible()).forNoMoreThan(TIEMPO).seconds());
        driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        return driver.getCurrentUrl();
    }

    public static ValidarUrl deLaPagina(){
        return new ValidarUrl();
    }
}
