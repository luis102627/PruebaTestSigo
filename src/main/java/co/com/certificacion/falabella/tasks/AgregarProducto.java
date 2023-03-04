package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.certificacion.falabella.userinterfaces.Falabella.BTN_AGREGAR_A_BOLSA;
import static co.com.certificacion.falabella.userinterfaces.Falabella.BTN_VER_BOLSA_DE_COMPRAS;
import static co.com.certificacion.falabella.utils.Constantes.TIEMPO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;

public class AgregarProducto implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(WaitUntil.the(BTN_AGREGAR_A_BOLSA, isVisible()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(BTN_AGREGAR_A_BOLSA),
                WaitUntil.the(BTN_VER_BOLSA_DE_COMPRAS, isVisible()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(BTN_VER_BOLSA_DE_COMPRAS));
    }

    public static AgregarProducto aLaBolsa() {
        return instrumented(AgregarProducto.class);
    }
}
