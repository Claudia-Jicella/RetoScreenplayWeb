package com.automationpractice.utils.contacUs;

public enum ChooseUtil {

    CUSTOMERSERVICE("Customer service"),
    WEBMASTER("Webmaster");

    private final String value;


    public String getValue() { return value;}

    ChooseUtil (String value) {
        this.value = value;
    }

}
