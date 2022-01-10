package com.automationpractice.stepdefinition.contacUs;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.openqa.selenium.WebDriver;

import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;

public class Setup {

    @Managed()
    protected WebDriver webDriver;

    private void setupUser(String nombre, WebDriver webDriver){
        OnStage.setTheStage(new OnlineCast());
        theActorCalled(nombre).can(BrowseTheWeb.with(webDriver));
    }

    protected  void  actorSetupTheBrowser(){
        setupUser("Claudia", webDriver);
    }


    //configuracion del log4j

}
