package com.jorgealvarez.myboda.model;

public enum Status {
    NOT_CONFIRMED("No confirmado"), CONFIRMED("Confirmado"), CANCELED("Cancelado");
    private final String displayValue;

    private Status (String displayValue) {
        this.displayValue = displayValue;
    }
    public String getDisplayValue() {
        return displayValue;
    }


}
