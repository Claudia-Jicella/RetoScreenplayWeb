package com.automationpractice.stepdefinition.signIn;

import com.automationpractice.exceptions.ValidacionText;
import com.automationpractice.models.signIn.SignInFormModel;
import com.automationpractice.stepdefinition.contacUs.Setup;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.apache.log4j.Logger;
import org.junit.jupiter.api.Assertions;
import static com.automationpractice.exceptions.ValidacionText.VALIDATION_DO_NOT_MATCH;
import static com.automationpractice.questions.practiceWebsite.signIn.CustomerSignInSuccessfully.customerSignInSuccessfully;
import static com.automationpractice.questions.practiceWebsite.signIn.CustomerWasSuccessfullyCreated.customerWasSuccessfullyCreated;
import static com.automationpractice.tasks.OpenLandingPage.openLandingPage;
import static com.automationpractice.tasks.singIn.BrowseToSignIn.browseToSignIn;
import static com.automationpractice.tasks.singIn.FillCreateAccountForm.fillCreateAccountForm;
import static com.automationpractice.tasks.singIn.FillSignInForm.fillSignInForm;
import static com.automationpractice.userinterfaces.signIn.SignInPage.CREATESUCCESSFUL;
import static com.automationpractice.userinterfaces.signIn.SignInPage.SIGNINSUCCESSFUL;
import static com.automationpractice.utils.signIn.SignedIn.MYACC;
import static com.automationpractice.utils.signIn.Title.MRS;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static org.hamcrest.CoreMatchers.equalTo;


public class SignInStepDefinition extends Setup {

    private static final Logger LOGGER = Logger.getLogger(SignInStepDefinition.class);
    SignInFormModel signInFormModel;



    //Background
    @Given("que el cliente está en la página principal de la tienda virtual Your y navega hasta Sign in")
    public void queElClienteEstáEnLaPáginaPrincipalDeLaTiendaVirtualYourYNavegaHastaSignIn() {

        try {
            actorSetupTheBrowser();

            theActorInTheSpotlight().wasAbleTo(
                    openLandingPage(),
                    browseToSignIn()
            );
        } catch (Exception e) {
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(), e);
        }
    }

    //Scenario1
    @When("el cliente vaya a crear la cuenta, llene los datos obligatorios y los envie")
    public void elClienteVayaACrearLaCuentaLleneLosDatosObligatoriosYLosEnvie() {

        try{
            generateFullCustomer();

            theActorInTheSpotlight().attemptsTo(
                    fillCreateAccountForm()
                            .withTheCorreo(signInFormModel.getCorreo())
                            .andTheTitulo(signInFormModel.getTitulo())
                            .andTheNombre(signInFormModel.getNombre())
                            .andTheApellido(signInFormModel.getApellido())
                            .andTheContrasena(signInFormModel.getContrasena())
                            .andTheDireccion(signInFormModel.getDireccion())
                            .andTheCiudad(signInFormModel.getCiudad())
                            .andTheCodigoPostal(signInFormModel.getCodigoPostal())
                            .andTheTelefono(signInFormModel.getTelefono())
                            .andTheDireccionAlias(signInFormModel.getDireccionAlias())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }


    }

    @Then("el sistema lo deja dentro del inicio de sesion")
    public void elSistemaLoDejaDentroDelInicioDeSesion() {

        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            customerWasSuccessfullyCreated()
                                    .withTheWelcomeMessage(MYACC.getValue())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidacionText.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSystemOutcome())
                            ),
                    seeThat(
                            customerSignInSuccessfully()
                                    .withCustomersName(signInFormModel.getNombre() + " " +
                                            signInFormModel.getApellido())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidacionText.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSignInOutcome())
                            )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }

    }


    //Scenario2
    @When("el cliente autentique el inicio de sesion")
    public void elClienteAutentiqueElInicioDeSesion() {

        try{
            generateSignInCustomer();

            theActorInTheSpotlight().attemptsTo(
                    fillSignInForm()
                            .withTheEmail(signInFormModel.getCorreo())
                            .andThePassword(signInFormModel.getContrasena())
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }



    }

    @Then("el cliente inicia sesion en la pagina web")
    public void elClienteIniciaSesionEnLaPaginaWeb() {

        try{
            theActorInTheSpotlight().should(
                    seeThat(
                            customerSignInSuccessfully()
                                    .withCustomersName(signInFormModel.getNombre() + " " +
                                            signInFormModel.getApellido())
                                    .is(), equalTo(true)
                    )
                            .orComplainWith(
                                    ValidacionText.class,
                                    String.format(VALIDATION_DO_NOT_MATCH, compareWithSignInOutcome())
                            )
            );
        } catch (Exception e){
            Assertions.fail(e.getMessage());
            LOGGER.warn(e.getMessage(),e);
        }
    }

    private void generateFullCustomer(){
        signInFormModel = new SignInFormModel();
        signInFormModel.setTitulo(MRS.getValue());
        signInFormModel.setNombre("juliana");
        signInFormModel.setApellido("sanchez");
        signInFormModel.setCorreo("julianas@myemail.com");
        signInFormModel.setContrasena("SanchezJul445");
        signInFormModel.setDireccion("2655 Le Jeune Road, FL 33556");
        signInFormModel.setCiudad("Miami");
        signInFormModel.setCodigoPostal("45624");
        signInFormModel.setTelefono("9008899955");
        signInFormModel.setDireccionAlias("Home");
    }

    private void generateSignInCustomer(){
        signInFormModel = new SignInFormModel();
        signInFormModel.setNombre("juliana");
        signInFormModel.setApellido("sanchez");
        signInFormModel.setCorreo("julianas@myemail.com");
        signInFormModel.setContrasena("SanchezJul445");
    }

    private String compareWithSignInOutcome(){
        return "\n" + "Expected : System Outcome" +
                "\n" + signInFormModel.getNombre() + " " + signInFormModel.getApellido() + " : " +
                SIGNINSUCCESSFUL.resolveFor(theActorInTheSpotlight()).getText();
    }
    private String compareWithSystemOutcome(){
        return "\n" + "Expected : System Outcome" +
                "\n" + MYACC.getValue() + " : " +
                CREATESUCCESSFUL.resolveFor(theActorInTheSpotlight()).getText();
    }


}
