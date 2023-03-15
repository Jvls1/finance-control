package com.jojo.financialcontrol.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Routes {

    private final static String PREFIX = "/api";
    private final static String USER = PREFIX+"/user";
    private final static String INCOME = PREFIX+"/income";
    private final static String EXPENSE = PREFIX+"/expense";
    private final static String WALLET = PREFIX+"/wallet";

}
