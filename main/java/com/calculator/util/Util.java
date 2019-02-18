package com.calculator.util;

public class Util {

    public static boolean isSeparator(char element) {
        return " =".indexOf(element) != -1;
    }

    public static boolean isOperator(char element) {
        return "+-/*()".indexOf(element) != -1;
    }

    public static byte getPriprity(char element) {
        switch (element) {
            case '(': return 0;
            case ')': return 1;
            case '+': return 2;
            case '-': return 3;
            case '*': return 4;
            case '/': return 5;
            default: return 6;
        }
    }

    public static boolean isRomeNumericSystem(String expression) {
        return !expression.contains("\\d+");
    }
}
