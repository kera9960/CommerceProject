package com.example.commerce;

import java.util.Scanner;

public class InputParser {

    public int toInteger(String input){
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new NumberFormatException("잘못된 숫자");
        }
    }
    public int inputInt(Scanner sc){
        while (true){
            String input = sc.nextLine();
            try {
                int output = toInteger(input);
                return output;
            } catch (NumberFormatException e){
                System.out.println("숫자를 입력하세요.");
            }
        }
    }

    public int minMax(Scanner sc, int min, int max){
        while (true){
            int input = inputInt(sc);
            if (input >= min && input <= max){
                return input;
            } else {
                System.out.println("다시 입력해주세요.");
            }
        }
    }
}
