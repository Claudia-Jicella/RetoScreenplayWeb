package com.automationpractice.userinterfaces.contacUs;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ContacUs extends PageObject {

    public static final Target CONTACUS = Target
            .the("ContacUs")
            .located(By.xpath("//*[@id=\"contact-link\"]"));

    public static final Target SELECCIONARASUNTO = Target
            .the("CHOOSE")
            .located(By.xpath("//option[text()='Customer service']"));


    public static final Target CUSTOMERSERVICE_CHOOSE = Target
            .the("CustomerService")
            .located(By.xpath("//option[text()='Customer service']"));

    public static final Target WEBMASTER_CHOOSE = Target
            .the("Webmaster")
            .located(By.xpath("//option[text()='Webmaster']"));


    public static final Target CORREOELECT = Target
            .the("EmailAddress")
            .located(By.id("email"));


    public static final Target REFERECIADELPEDIDO = Target
            .the("OrderReference")
            .located(By.xpath("//*[@id=\"id_order\"]"));

    public static final Target MENSAJE = Target
            .the("Message")
            .located(By.xpath("//*[@id=\"message\"]"));

    public static final Target ENVIAR = Target
            .the("Send")
            .located(By.xpath("//*[@id=\"submitMessage\"]/span"));

    //Validaciones

    public static final Target MENSAJEVALIDACION = Target
            .the("Mensaje de Validacion")
            .located(By.xpath("//*[@id=\"center_column\"]/p"));


}
