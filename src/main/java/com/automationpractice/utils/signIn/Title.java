package com.automationpractice.utils.signIn;

public enum Title {
    MR("Mr."),
    MRS("Mrs.");

    private final String value;

    Title(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
