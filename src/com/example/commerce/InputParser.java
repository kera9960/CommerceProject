package com.example.commerce;

public class InputParser {

    public Integer toInteger(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new NumberFormatException("잘못된 숫자");
        }
    }
}
