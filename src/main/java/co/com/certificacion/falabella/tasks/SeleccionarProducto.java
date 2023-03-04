package co.com.certificacion.falabella.tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.targets.Target;
import net.serenitybdd.screenplay.waits.WaitUntil;
import net.thucydides.core.webdriver.SerenityWebdriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import static co.com.certificacion.falabella.utils.Constantes.TIEMPO;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class SeleccionarProducto implements Task {
    private WebDriver driver;
    private String producto;

    public SeleccionarProducto(String producto) {
        this.producto = producto;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        driver = SerenityWebdriverManager.inThisTestThread().getCurrentDriver();
        Target RESULTADO_CONSULTA_FALABELLA = Target.the("resultado de consulta en flaabella")
                .located(By.xpath("//b[contains(text(),'" + producto + "')]"));
        actor.attemptsTo(WaitUntil.the(RESULTADO_CONSULTA_FALABELLA, WebElementStateMatchers.isVisible()).forNoMoreThan(TIEMPO).seconds(),
                Click.on(RESULTADO_CONSULTA_FALABELLA));
    }

    public static SeleccionarProducto consultado(String producto) {
        return instrumented(SeleccionarProducto.class, producto);
    }
}
