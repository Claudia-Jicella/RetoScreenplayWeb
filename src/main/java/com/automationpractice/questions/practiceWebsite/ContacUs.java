package com.automationpractice.questions.practiceWebsite;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;

import static com.automationpractice.userinterfaces.contacUs.ContacUs.MENSAJEVALIDACION;


public class ContacUs implements Question<Boolean> {


    private String mensajeValidacion;

    public String getMensajeValidacion() {
        return mensajeValidacion;

    }

    public ContacUs tieneElMensajeValidacion(String mensajeValidacion) {
        this.mensajeValidacion = mensajeValidacion;
        return this;
    }


    public ContacUs is(){
        return this;
    }

    @Override
    public Boolean answeredBy(Actor actor) {
        return (MENSAJEVALIDACION.resolveFor(actor).containsOnlyText(mensajeValidacion)

        );
    }

    public static ContacUs contacUs(){return new ContacUs();}


}
