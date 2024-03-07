package com.app.firststore.Adapters;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class DataValidator {
    private static final int MIN_VALUE = 1; // Замените на минимальное допустимое значение

    public static boolean isValid(String  field1, String  field2, String field3, String field3_1, String field4) {
        return isInRangeNumber(field1) && isInRangeThird(field2) && isInRangeDate(field3, field3_1) && isInRange(field4);
    }

    private static boolean isInRangeNumber(String value) {
        boolean a = value.length()==16;
        System.out.println(a+" ");
        return value.length() == 16;
    }
    private static boolean isInRangeThird(String value) {
        boolean a = value.length()==3;
        System.out.println(a+" ");
        return value.length() == 3;
    }
    private static boolean isInRangeDate(String value, String value_2) {
        boolean a = (value.length()==2) && (value_2.length()==2);
        System.out.println(a+" ");
        return value.length() == 2 && value_2.length() == 2;
    }
    private static boolean isInRange(String value) {
        return value.length() >= MIN_VALUE;
    }
}
