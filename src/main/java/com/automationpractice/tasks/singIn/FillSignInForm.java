package com.automationpractice.tasks.singIn;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.automationpractice.userinterfaces.signIn.SignInPage.*;

public class FillSignInForm implements Task {

    private String email;
    private String password;

    public FillSignInForm withTheEmail(String email) {
        this.email = email;
        return this;
    }

    public FillSignInForm andThePassword(String password) {
        this.password = password;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGNINEMAIL),
                Enter.theValue(email).into(SIGNINEMAIL),

                Scroll.to(SIGNINPASSWORD),
                Enter.theValue(password).into(SIGNINPASSWORD),

                Scroll.to(SIGNINBUTTON),
                Click.on(SIGNINBUTTON)
        );
    }

    public static FillSignInForm fillSignInForm() {
        return new FillSignInForm();
    }
}