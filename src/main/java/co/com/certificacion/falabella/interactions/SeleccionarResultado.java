package co.com.certificacion.falabella.interactions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.certificacion.falabella.userinterfaces.Google.RESULTADO_FALABELLA;
import static co.com.certificacion.falabella.utils.Constantes.TIEMPO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class SeleccionarResultado implements Interaction {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(RESULTADO_FALABELLA,isClickable()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(RESULTADO_FALABELLA));
    }

    public static SeleccionarResultado deBusqueda(){
        return instrumented(SeleccionarResultado.class);
    }
}
