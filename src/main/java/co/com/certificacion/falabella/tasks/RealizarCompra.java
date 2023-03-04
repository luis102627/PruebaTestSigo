package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;

import static co.com.certificacion.falabella.userinterfaces.Falabella.BTN_IR_A_COMPRAR;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class RealizarCompra implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(Click.on(BTN_IR_A_COMPRAR));
    }

    public static RealizarCompra deProducto(){
        return instrumented(RealizarCompra.class);
    }
}
