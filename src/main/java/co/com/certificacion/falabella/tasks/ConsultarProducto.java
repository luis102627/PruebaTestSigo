package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.waits.WaitUntil;
import org.openqa.selenium.Keys;

import static co.com.certificacion.falabella.userinterfaces.Falabella.TXT_SEARCH_FALABELLA;
import static co.com.certificacion.falabella.utils.Constantes.TIEMPO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class ConsultarProducto implements Task {
    private String producto;

    public ConsultarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(TXT_SEARCH_FALABELLA, isVisible()).forNoMoreThan(TIEMPO).seconds(),
                Enter.theValue(producto).into(TXT_SEARCH_FALABELLA)
                        .thenHit(Keys.ENTER));
    }

    public static ConsultarProducto enFalabella(String producto) {
        return instrumented(ConsultarProducto.class, producto);
    }
}
