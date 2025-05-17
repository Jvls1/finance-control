package com.jojo.financialcontrol.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum EnumBuyMethod {

    CREDIT_CARD("Credit Card"),
    DEBIT_CARD("Debit Card"),
    CASH("Cash"),
    OTHER("Other");

    private final String description;

}
