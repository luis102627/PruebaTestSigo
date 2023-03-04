package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;

import static co.com.certificacion.falabella.userinterfaces.Falabella.LISTA_GARANTIA;
import static co.com.certificacion.falabella.userinterfaces.Falabella.OPCIONES_GARANTIA;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ElegirGarantia implements Task {
    private String garantia;

    public ElegirGarantia(String garantia) {
        this.garantia = garantia;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        switch (garantia){
            case "No, gracias":
                actor.attemptsTo(WaitUntil.the(LISTA_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(LISTA_GARANTIA)
                        ,WaitUntil.the(OPCIONES_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(OPCIONES_GARANTIA.resolveAllFor(actor).get(0)));
                break;
            case "1":
                actor.attemptsTo(WaitUntil.the(LISTA_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(LISTA_GARANTIA)
                        ,WaitUntil.the(OPCIONES_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(OPCIONES_GARANTIA.resolveAllFor(actor).get(1)));
                break;
            case "2":
                actor.attemptsTo(WaitUntil.the(LISTA_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(LISTA_GARANTIA)
                        ,WaitUntil.the(OPCIONES_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(OPCIONES_GARANTIA.resolveAllFor(actor).get(2)));
                break;
            case "3":
                actor.attemptsTo(WaitUntil.the(LISTA_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(LISTA_GARANTIA)
                        ,WaitUntil.the(OPCIONES_GARANTIA, WebElementStateMatchers.isVisible())
                        ,Click.on(OPCIONES_GARANTIA.resolveAllFor(actor).get(3)));
                break;

            default:
                System.out.println("Esta opcion no existe");
        }
    }

    public static ElegirGarantia delProducto(String garantia){
        return instrumented(ElegirGarantia.class,garantia);
    }
}
