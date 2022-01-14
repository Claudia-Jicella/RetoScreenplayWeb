package com.automationpractice.questions.practiceWebsite.signIn;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automationpractice.userinterfaces.signIn.SignInPage.CREATESUCCESSFUL;

public class CustomerWasSuccessfullyCreated implements Question<Boolean> {

    private String welcomeMessage;

    public CustomerWasSuccessfullyCreated withTheWelcomeMessage(String message){
        this.welcomeMessage = message;
        return this;
    }

    public CustomerWasSuccessfullyCreated is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (CREATESUCCESSFUL.resolveFor(actor).containsOnlyText(welcomeMessage));
    }

    public static CustomerWasSuccessfullyCreated customerWasSuccessfullyCreated(){
        return new CustomerWasSuccessfullyCreated();
    }

}
