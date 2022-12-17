package com.jojo.financialcontrol.utils;

import org.springframework.util.StringUtils;

import java.util.regex.Pattern;

public abstract class StringUtil extends StringUtils {

    public static boolean isEmailValid(String email) {
        if (email == null) {
            return false;
        }
        String regexPattern = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
                + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$";

        return Pattern.compile(regexPattern).matcher(email).matches();
    }
}
