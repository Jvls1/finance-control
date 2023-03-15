package com.jojo.financialcontrol.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
public class Routes {

    public final static String PREFIX = "/api";
    public final static String USER = PREFIX+"/user";
    public final static String INCOME = PREFIX+"/income";
    public final static String EXPENSE = PREFIX+"/expense";
    public final static String WALLET = PREFIX+"/wallet";

}
