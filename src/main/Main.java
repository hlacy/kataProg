package main;

import java.util.IllegalFormatCodePointException;
import java.util.List;
import java.util.Scanner;


public class Main {

    public static boolean isArabicNumeric(String s) {
        return s != null && s.matches("^[0-9]*$");
    }
//    I обозначает 1, V обозначает 5, X Ч 10, L Ч 50, C Ч 100, D Ч 500, M Ч 1000.
    public static boolean isRomanNumeric(String s){
//        return s != null && s.matches("^[IVXLCDM]*$");
        return s != null && s.matches("^[IVX]*$");
    }
    public static boolean checkOperators(String s){
        return s != null && s.length() < 2 && s.matches("^[\\/\\*\\-\\+]*$");
    }

    public static int romanToArabic(String input) throws Exception {
        String romanNumber = input;
        int arabicNumber = 0;

        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();

        int i = 0;

        while ((romanNumber.length() > 0) && (i < romanNumbers.size())) {
            RomanNumbers symbol = romanNumbers.get(i);
            if (romanNumber.startsWith(symbol.name())) {
                arabicNumber += symbol.getValue();
                romanNumber = romanNumber.substring(symbol.name().length());
            } else {
                i++;
            }
        }

        if (romanNumber.length() > 0) {
            throw new Exception("cannot be converted");
        }
        if (arabicNumber > 10 || arabicNumber < 1){
            throw new Exception("the numbers/number are out of range [1;10]");
        }

        return arabicNumber;
    }

    public static String arabicToRoman(int number) throws Exception {
        if ((number <= 0) || (number > 4000)) {
            throw new Exception(number + " is not in range (0,4000]");
        }

        List<RomanNumbers> romanNumbers = RomanNumbers.getReverseSortedValues();

        int i = 0;
        StringBuilder sb = new StringBuilder();

        while ((number > 0) && (i < romanNumbers.size())) {
            RomanNumbers currentSymbol = romanNumbers.get(i);
            if (currentSymbol.getValue() <= number) {
                sb.append(currentSymbol.name());
                number -= currentSymbol.getValue();
            } else {
                i++;
            }
        }
        return sb.toString();
    }

    public static String calc(String input) throws Exception {
        String answer = new String();
        String[] data = input.split(" ");
        if (data.length != 3){
            throw new Exception();
        }
        if (!checkOperators(data[1])){
            throw new Exception("second character contains non operation symbols, or equals null, or length bigger 1");
        }
        Integer numb1;
        Integer numb2;
        if (isArabicNumeric(data[0])&&isArabicNumeric(data[2])){
            numb1 = Integer.parseInt(data[0]);
            numb2 = Integer.parseInt(data[2]);
            if (numb1 < 1 || numb1 > 10 || numb2 < 1 || numb2 > 10){
                throw new Exception("the numbers/number are out of range [1;10]");
            }
            switch (data[1]) {
                case "+":
                    return Integer.toString(numb1 + numb2);
                case "-":
                    return Integer.toString(numb1 - numb2);
                case "*":
                    return Integer.toString(numb1 * numb2);
                case "/":
                    return Integer.toString(numb1 / numb2);
            }
        }

        if (isRomanNumeric(data[0])&&isRomanNumeric(data[2])){
            numb1 = romanToArabic(data[0]);
            numb2 = romanToArabic(data[2]);
            Integer result = -1;
            switch (data[1]){
                case "+":
                    result = numb1 + numb2;
                    break;
                case "-":
                    result = numb1 - numb2;
                    break;
                case "*":
                    result = numb1 * numb2;
                    break;
                case "/":
                    result = numb1 / numb2;
                    break;
            }
            if (result < 1){
                throw new Exception("result < 1");
            }
            return arabicToRoman(result);
        }
        throw new Exception();
    }
}