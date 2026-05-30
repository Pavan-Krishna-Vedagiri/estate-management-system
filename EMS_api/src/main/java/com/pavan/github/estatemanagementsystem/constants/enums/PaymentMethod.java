package com.pavan.github.estatemanagementsystem.constants.enums;
public enum PaymentMethod {
    Cash("Cash"),
    CreditCard("Credit Card"),
    UPI("UPI"),
    BankTransfer("Bank Transfer");

    private final String value;

    PaymentMethod(String value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return value;
    }
}
