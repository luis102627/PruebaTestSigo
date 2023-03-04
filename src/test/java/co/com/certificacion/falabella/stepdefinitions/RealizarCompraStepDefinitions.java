package co.com.certificacion.falabella.stepdefinitions;

import co.com.certificacion.falabella.interactions.SeleccionarResultado;
import co.com.certificacion.falabella.questions.ValidarUrl;
import co.com.certificacion.falabella.tasks.*;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import net.serenitybdd.screenplay.GivenWhenThen;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import org.hamcrest.Matchers;

import static co.com.certificacion.falabella.utils.Constantes.URL_GOOGLE;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class RealizarCompraStepDefinitions {
    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        OnStage.setTheStage(new OnlineCast());
        theActorCalled("Certifier");
    }

    @Given("^que el usuario se encuentra en la pagina de google$")
    public void queElUsuarioSeEncuentraEnLaPaginaDeGoogle() {
        OnStage.theActorInTheSpotlight().wasAbleTo(Open.url(URL_GOOGLE));
    }

    @When("^el usuario ingrese la palabra (.*) en el campo de busqueda$")
    public void elUsuarioIngreseLaPalabraFalabellaEnElCampoDeBusqueda(String palabraBusqueda) {
        OnStage.theActorInTheSpotlight().attemptsTo(RealizarConsulta.enGoogle(palabraBusqueda));
    }

    @And("^el usuario seleccione la tienda de colombia$")
    public void elUsuarioSeleccioneLaTiendaDeColombia() {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarResultado.deBusqueda());
    }

    @And("^el usuario consulte un producto (.*)$")
    public void elUsuarioConsulteUnProductoProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(ConsultarProducto.enFalabella(producto));
    }

    @And("^el usuario seleccione el producto (.*)$")
    public void elUsuarioSeleccioneElProducto(String producto) {
        OnStage.theActorInTheSpotlight().attemptsTo(SeleccionarProducto.consultado(producto));
    }

    @And("^el usuario agregue el producto al carro de compras$")
    public void elUsuarioAgregueElProductoAlCarroDeCompras() {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarProducto.aLaBolsa());
    }

    @And("^el usuario elija la (.*)$")
    public void elUsuarioElijaLa(String garantia) {
        OnStage.theActorInTheSpotlight().attemptsTo(ElegirGarantia.delProducto(garantia));
    }

    @And("^el usuario aumente la cantidad del producto$")
    public void elUsuarioAumenteLaCantidadDelProducto() {
        OnStage.theActorInTheSpotlight().attemptsTo(AgregarMas.productos());
    }

    @And("^el usuario seleccione la opcion ir a comprar$")
    public void elUsuarioSeleccioneLaOpcionIrAComprar() {
        OnStage.theActorInTheSpotlight().attemptsTo(RealizarCompra.deProducto());
    }

    @Then("^el sistema presenta el resumen de la orden en la siguiente url (.*)$")
    public void elSistemaPresentaElResumenDeLaOrdenEnLaSiguienteUrl(String url) {
        OnStage.theActorInTheSpotlight().should(GivenWhenThen.seeThat(ValidarUrl.deLaPagina(), Matchers.equalTo(url)));
    }
}
