package com.automationpractice.stepdefinition.contacUs.contacUs;

import com.automationpractice.exceptions.ValidacionText;
import com.automationpractice.models.contacUs.ContacUsModel;
import com.automationpractice.stepdefinition.contacUs.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import static com.automationpractice.exceptions.ValidacionText.VALIDATION_DO_NOT_MATCH;
import static com.automationpractice.questions.practiceWebsite.ContacUs.contacUs;
import static com.automationpractice.tasks.OpenLandingPage.openLandingPage;
import static com.automationpractice.tasks.contacUs.BrowseContacUs.browseContacUs;
import static com.automationpractice.tasks.contacUs.FillContacUs.fillContacUs;
import static com.automationpractice.userinterfaces.contacUs.ContacUs.MENSAJEVALIDACION;
import static com.automationpractice.utils.ChooseUtil.CUSTOMERSERVICE;
import static com.automationpractice.utils.ChooseUtil.WEBMASTER;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class ContacUsStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(ContacUsStepDefinition.class);

    private ContacUsModel actor;

    //Background
    @Given("que el cliente está en la página principal de la tienda virtual Your")
    public void queElClienteEstaEnLaPaginaPrincipalDeLaTiendaVirtualYour() {

        try{
            actorSetupTheBrowser();
            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage()
            );

        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }

    }

    //Scenario1
    @When("selecciona Contac us la opcion Servicio al cliente e ingrese los campos obligatorios")
    public void seleccionaContacUsLaOpcionServicioAlClienteEIngreseLosCamposObligatorios() {

        try {
            ContacUsModel contacUsModel = new ContacUsModel();
            contacUsModel.setAsunto(CUSTOMERSERVICE.getValue());
            contacUsModel.setCorreoElect("pruebasqa@gmail.com");
            contacUsModel.setReferenciaPedido("12345hhc");
            contacUsModel.setMensaje("Solicitud de factura");

            theActorInTheSpotlight().attemptsTo(
                    browseContacUs(),
                    fillContacUs()
                            .withAsunto(contacUsModel.getAsunto())
                            .andCorreoElect(contacUsModel.getCorreoElect())
                            .andReferenciaPedido(contacUsModel.getReferenciaPedido())
                            .andMensaje(contacUsModel.getMensaje())
            );
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }

    }

    @Then("el sistema debera mostrar un mensaje de confimacion de envio de la solicitud")
    public void elSistemaDeberaMostrarUnMensajeDeConfimacionDeEnvioDeLaSolicitud() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            contacUs()
                                    .tieneElMensajeValidacion("Your message has been successfully sent to our team.")
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidacionText.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome())
                            )
            );

        }catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }

    }

    private String compareInWithSystemOutcome(){
        return "\n" + "Data for test : System outcome"
                + "\n" + contacUs().getMensajeValidacion() + MENSAJEVALIDACION.resolveFor(theActorInTheSpotlight()).getText()
                ;
    }

    //Scenario2
    @When("seleccione Contac us la opcion Webmaster e ingrese los campos obligatorios")
    public void seleccioneContacUsLaOpcionWebmasterEIngreseLosCamposObligatorios() {

        try {
            ContacUsModel contacUsModel = new ContacUsModel();
            contacUsModel.setAsunto(WEBMASTER.getValue());
            contacUsModel.setCorreoElect("sofkareto@gmail.com");
            contacUsModel.setReferenciaPedido("774626egdhk");
            contacUsModel.setMensaje("pedido");

            theActorInTheSpotlight().attemptsTo(
                    browseContacUs(),
                    fillContacUs()
                            .withAsunto(contacUsModel.getAsunto())
                            .andCorreoElect(contacUsModel.getCorreoElect())
                            .andReferenciaPedido(contacUsModel.getReferenciaPedido())
                            .andMensaje(contacUsModel.getMensaje())
            );
        }catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }

    }

    @Then("la pagina debera imprimir en pantalla la confirmacion de la solicitud")
    public void laPaginaDeberaImprimirEnPantallaLaConfirmacionDeLaSolicitud() {

        try {
            theActorInTheSpotlight().should(
                    seeThat(
                            contacUs()
                                    .tieneElMensajeValidacion("Your message has been successfully sent to our team.")
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidacionText.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareInWithSystemOutcome())
                            )
            );

        }catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }

    }
}
