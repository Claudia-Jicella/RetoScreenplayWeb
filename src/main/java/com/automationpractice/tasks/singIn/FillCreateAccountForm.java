package com.automationpractice.tasks.singIn;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Scroll;
import net.serenitybdd.screenplay.conditions.Check;

import static com.automationpractice.userinterfaces.signIn.SignInPage.*;
import static com.automationpractice.utils.signIn.Title.MR;

public class FillCreateAccountForm implements Task {

    private String titulo;
    private String nombre;
    private String apellido;
    private String correo;
    private String contrasena;
    private String direccion;
    private String ciudad;
    private String codigoPostal;
    private String telefono;
    private String direccionAlias;


    public FillCreateAccountForm withTheCorreo(String correo) {
        this.correo = correo;
        return this;
    }

    public FillCreateAccountForm andTheTitulo(String titulo) {
        this.titulo = titulo;
        return this;
    }

    public FillCreateAccountForm andTheNombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public FillCreateAccountForm andTheApellido(String apellido) {
        this.apellido = apellido;
        return this;
    }



    public FillCreateAccountForm andTheContrasena(String contrasena) {
        this.contrasena = contrasena;
        return this;
    }


    public FillCreateAccountForm andTheDireccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public FillCreateAccountForm andTheCiudad(String ciudad) {
        this.ciudad = ciudad;
        return this;
    }


    public FillCreateAccountForm andTheCodigoPostal(String codigoPostal) {
        this.codigoPostal = codigoPostal;
        return this;
    }

    public FillCreateAccountForm andTheTelefono(String telefono) {
        this.telefono = telefono;
        return this;
    }

    public FillCreateAccountForm andTheDireccionAlias(String direccionAlias) {
        this.direccionAlias = direccionAlias;
        return this;
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Scroll.to(CREATEEMAIL),
                Enter.theValue(correo).into(CREATEEMAIL),

                Scroll.to(CREATEACCOUNTBUTTON),
                Click.on(CREATEACCOUNTBUTTON),

                Check.whether(titulo.equals(MR.getValue()))
                        .andIfSo(
                                Scroll.to(CREATETITLEMR),
                                Click.on(CREATETITLEMR)
                        )
                        .otherwise(
                                Scroll.to(CREATETITLEMRS),
                                Click.on(CREATETITLEMRS)
                        ),

                Scroll.to(CREATEFIRSTNAME),
                Enter.theValue(nombre).into(CREATEFIRSTNAME),

                Scroll.to(CREATELASTNAME),
                Enter.theValue(apellido).into(CREATELASTNAME),

                Scroll.to(CREATEPASSWORD),
                Enter.theValue(contrasena).into(CREATEPASSWORD),

                Scroll.to(CREATEADDRESS),
                Enter.theValue(direccion).into(CREATEADDRESS),

                Scroll.to(CREATECITY),
                Enter.theValue(ciudad).into(CREATECITY),

                Scroll.to(CREATESTATE),
                Click.on(CREATESTATE),

                Scroll.to(CREATEZIPCODE),
                Enter.theValue(codigoPostal).into(CREATEZIPCODE),

                Scroll.to(CREATEMOBILEPHONE),
                Enter.theValue(telefono).into(CREATEMOBILEPHONE),

                Scroll.to(CREATEADDRESSALIAS),
                Enter.theValue(direccionAlias).into(CREATEADDRESSALIAS),

                Scroll.to(CREATESUBMITBUTTON),
                Click.on(CREATESUBMITBUTTON)
        );
    }

    public static FillCreateAccountForm fillCreateAccountForm(){
        return new FillCreateAccountForm();
    }
}
