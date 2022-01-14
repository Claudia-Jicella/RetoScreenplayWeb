package com.automationpractice.tasks.singIn;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.automationpractice.userinterfaces.signIn.SignInPage.SIGNIN;

public class BrowseToSignIn implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(SIGNIN),
                Click.on(SIGNIN)
        );
    }

    public static BrowseToSignIn browseToSignIn() {
        return new BrowseToSignIn();
    }
}
