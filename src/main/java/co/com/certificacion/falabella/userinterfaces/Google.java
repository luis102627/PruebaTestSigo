package co.com.certificacion.falabella.userinterfaces;


import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Google {
    public static final Target TXT_SEARCH = Target.the("Campo buscar de google")
            .located(By.name("q"));
    public static final Target BTN_BUSCAR = Target.the("botón buscar con google")
            .located(By.name("btnK"));
    public static final Target RESULTADO_FALABELLA = Target.the("resultado consulta falabella")
            .located(By.xpath("//span[contains(text(),'https://www.falabella.com.co')]"));
}
