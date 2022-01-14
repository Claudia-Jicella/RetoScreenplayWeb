package com.automationpractice.userinterfaces.signIn;

import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.screenplay.targets.Target;

import static org.openqa.selenium.By.*;

public class SignInPage extends PageObject {


    public static final Target SIGNIN = Target
            .the("Sign In")
            .located(className("login"));



    public static final Target SIGNINEMAIL = Target
            .the("Sign In email field")
            .located(id("email"));

    public static final Target SIGNINPASSWORD = Target
            .the("Sign In password field")
            .located(id("passwd"));

    public static final Target SIGNINBUTTON = Target
            .the("Sign In submit button")
            .located(id("SubmitLogin"));



    public static final Target CREATEEMAIL = Target
            .the("Create account email")
            .located(id("email_create"));

    public static final Target CREATEACCOUNTBUTTON = Target
            .the("Create account button")
            .located(id("SubmitCreate"));

    public static final Target CREATETITLEMR = Target
            .the("Create title Mr. field")
            .located(xpath("//label[@for='id_gender1']"));

    public static final Target CREATETITLEMRS = Target
            .the("Create title Mrs. field")
            .located(xpath("//label[@for='id_gender2']"));

    public static final Target CREATEFIRSTNAME = Target
            .the("Create first name field")
            .located(id("customer_firstname"));

    public static final Target CREATELASTNAME = Target
            .the("Create last name field")
            .located(id("customer_lastname"));

    public static final Target CREATEPASSWORD = Target
            .the("Create password field")
            .located(id("passwd"));

    public static final Target CREATEADDRESS = Target
            .the("Create address field")
            .located(id("address1"));

    public static final Target CREATECITY = Target
            .the("Create city field")
            .located(id("city"));

    public static final Target CREATESTATE = Target
            .the("Create state field")
            .located(xpath("//option[text()='Florida']"));

    public static final Target CREATEZIPCODE = Target
            .the("Create zip code field")
            .located(id("postcode"));

    public static final Target CREATEMOBILEPHONE = Target
            .the("Create mobile phone field")
            .located(id("phone_mobile"));

    public static final Target CREATEADDRESSALIAS = Target
            .the("Create address alias field")
            .located(id("alias"));

    public static final Target CREATESUBMITBUTTON = Target
            .the("Create submit button")
            .located(id("submitAccount"));

    //Validaciones
    public static final Target SIGNINSUCCESSFUL = Target
            .the("Sign in successful authentication")
            .located(xpath("//*[@id=\"header\"]/div[2]/div/div/nav/div[1]/a/span"));

    public static final Target CREATESUCCESSFUL = Target
            .the("Create My account success login")
            .located(xpath("//*[@id=\"center_column\"]/h1"));
}