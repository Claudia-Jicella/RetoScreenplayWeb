package com.automationpractice.questions.practiceWebsite.signIn;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automationpractice.userinterfaces.signIn.SignInPage.SIGNINSUCCESSFUL;

public class CustomerSignInSuccessfully implements Question<Boolean> {

    private String customersName;

    public CustomerSignInSuccessfully withCustomersName(String fullName) {
        this.customersName = fullName;
        return this;
    }

    public CustomerSignInSuccessfully is() {
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (SIGNINSUCCESSFUL.resolveFor(actor).containsOnlyText(customersName));
    }

    public static CustomerSignInSuccessfully customerSignInSuccessfully() {
        return new CustomerSignInSuccessfully();
    }
}
