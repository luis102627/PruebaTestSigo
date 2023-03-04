package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.JavaScriptClick;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.certificacion.falabella.userinterfaces.Falabella.BTN_AUMENTAR_PRODUCTOS;
import static co.com.certificacion.falabella.userinterfaces.Falabella.BTN_IR_A_COMPRAR;
import static co.com.certificacion.falabella.utils.Constantes.TIEMPO;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isClickable;

public class AgregarMas implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        int cantidad = (int)Math.floor(Math.random()*5+1);
        for (int i = 0; i<cantidad; i++){
            actor.attemptsTo(WaitUntil.the(BTN_AUMENTAR_PRODUCTOS,isClickable()).forNoMoreThan(TIEMPO).seconds()
                    , JavaScriptClick.on(BTN_AUMENTAR_PRODUCTOS));
        }
        actor.attemptsTo(WaitUntil.the(BTN_IR_A_COMPRAR, isClickable()).forNoMoreThan(TIEMPO).seconds());
    }

    public static AgregarMas productos(){
        return instrumented(AgregarMas.class);
    }
}
