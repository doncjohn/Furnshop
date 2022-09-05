package com.dondev.httpServer.validator;

public class NumericValidator {
    public static boolean isNumeric(String text){
        return text.chars().allMatch( Character::isDigit );
    }
}
