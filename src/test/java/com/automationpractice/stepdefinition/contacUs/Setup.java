package com.automationpractice.stepdefinition.contacUs;

import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.thucydides.core.annotations.Managed;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;

import static com.automationpractice.utils.Log4j.LOG4J_PROPERTIES_FILE_PATH;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static org.apache.commons.lang3.SystemUtils.getUserDir;

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


    /*private void setUpLog4j(){
        PropertyConfigurator.configure(osPathModify(defineOS(),getUserDir() + LOG4J_PROPERTIES_FILE_PATH.getValue()));
    }*/

}
