package com.automationpractice.tasks.contacUs;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Scroll;

import static com.automationpractice.userinterfaces.contacUs.ContacUs.CONTACUS;

public class BrowseContacUs implements Task {
    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(
                Scroll.to(CONTACUS),
                Click.on(CONTACUS)

        );
    }

    public static BrowseContacUs browseContacUs(){
        return new BrowseContacUs();
    }
}
