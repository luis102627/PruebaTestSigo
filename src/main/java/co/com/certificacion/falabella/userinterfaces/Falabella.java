package co.com.certificacion.falabella.userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class Falabella {
    public static final Target TXT_SEARCH_FALABELLA = Target.the("Campo buscar de falabella")
            .located(By.id("testId-SearchBar-Input"));
    public static final Target BTN_AGREGAR_A_BOLSA = Target.the("boton para agregar al carro")
            .located(By.id("add-to-cart-button"));
    public static final Target BTN_VER_BOLSA_DE_COMPRAS = Target.the("boton para ver la bolsa de compras")
            .located(By.id("linkButton"));
    public static final Target LISTA_GARANTIA = Target.the("lista para elegir garantia")
            .located(By.xpath("//div[@data-component='inlineDropdown']"));
    public static final Target OPCIONES_GARANTIA = Target.the("opciones lista garantia")
            .located(By.className("fb-inline-dropdown__list-item"));
    public static final Target BTN_IR_A_COMPRAR = Target.the("botón ir a comprar")
            .located(By.className("fb-order-status__cta"));
    public static final Target BTN_AUMENTAR_PRODUCTOS = Target.the("botón aumentar cantidad de productos")
            .located(By.className("increase"));
    public static final Target LB_OPCIONES_DESPACHO = Target.the("titulo opciones despacho")
            .located(By.xpath("//h2[contains(text(),'Elige tus opciones de despacho')]"));
    public static final Target LB_VALOR_PRODUCTO = Target.the("valor de productos")
            .located(By.xpath("//form[@class='fb-order-status__form']/child::div/child::div/child::div/child::p/child::span[2]"));
    public static final Target LB_TOTAL_PRODUCTOS = Target.the("valor total de productos")
            .located(By.xpath("//section[@class='fbra_section fbra_orderSummary']/child::div/child::ul[2]/child::li/child::span[2]"));
}
