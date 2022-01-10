package com.automationpractice.exceptions;

public class ValidacionText extends AssertionError{

    public static final String VALIDATION_DO_NOT_MATCH = "The validation don't match. %s";

    public ValidacionText (String message, Throwable cause){
        super(message, cause);
    }


}
