package com.automationpractice.tasks.contacUs;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import static com.automationpractice.userinterfaces.contacUs.ContacUs.*;
import static com.automationpractice.utils.contacUs.ChooseUtil.CUSTOMERSERVICE;
import static com.automationpractice.utils.contacUs.ChooseUtil.WEBMASTER;

public class FillContacUs implements Task {

    private String asunto;
    private String correoElect;
    private String referenciaPedido;
    private String mensaje;



    public FillContacUs withAsunto(String asunto) {
        this.asunto = asunto;
        return this;
    }

    public FillContacUs andCorreoElect(String correoElect) {
        this.correoElect = correoElect;
        return this;
    }

    public FillContacUs andReferenciaPedido(String referenciaPedido) {
        this.referenciaPedido = referenciaPedido;
        return this;
    }

    public FillContacUs andMensaje(String mensaje) {
        this.mensaje = mensaje;
        return this;
    }


    @Override
    public <T extends Actor> void performAs(T actor) {

        actor.attemptsTo(

                Check.whether(CUSTOMERSERVICE.getValue().equals(asunto))
                        .andIfSo(
                                Scroll.to(CUSTOMERSERVICE_CHOOSE),
                                Click.on(CUSTOMERSERVICE_CHOOSE)
                        )
                        .otherwise(
                                Check.whether(WEBMASTER.getValue().equals(asunto))
                                        .andIfSo(
                                                Scroll.to(WEBMASTER_CHOOSE),
                                                Click.on(WEBMASTER_CHOOSE)
                                        )
                        ),


                Scroll.to(CORREOELECT),
                Enter.theValue(correoElect).into(CORREOELECT),

                Scroll.to(REFERECIADELPEDIDO),
                Enter.theValue(referenciaPedido).into(REFERECIADELPEDIDO),

                Scroll.to(MENSAJE),
                Enter.theValue(mensaje).into(MENSAJE),

                Scroll.to(ENVIAR),
                Click.on(ENVIAR)

                );
    }
    public static FillContacUs fillContacUs(){
        return new FillContacUs();
    }
}
