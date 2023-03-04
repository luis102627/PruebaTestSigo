package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;

import static co.com.certificacion.falabella.userinterfaces.Google.BTN_BUSCAR;
import static co.com.certificacion.falabella.userinterfaces.Google.TXT_SEARCH;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarConsulta implements Task {
    private String palabraBusqueda;

    public RealizarConsulta(String palabraBusqueda) {
        this.palabraBusqueda = palabraBusqueda;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Enter.theValue(palabraBusqueda).into(TXT_SEARCH),
                Click.on(BTN_BUSCAR));
    }

    public static RealizarConsulta enGoogle(String palabraBusqueda){
        return instrumented(RealizarConsulta.class,palabraBusqueda);
    }
}
