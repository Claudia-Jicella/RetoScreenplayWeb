package com.automationpractice.utils.signIn;

public enum SignedIn {
    MYACC("MY ACCOUNT");

    private final String value;

    SignedIn(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
