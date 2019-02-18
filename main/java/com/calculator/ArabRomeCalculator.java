package com.calculator;

import com.calculator.util.Util;

import java.util.Scanner;
import java.util.Stack;

public class ArabRomeCalculator {

    //private boolean ArabNumericSystem;

    public void run() {
        Scanner scanner = new Scanner(System.in);
        String expression = scanner.nextLine();

        if (Util.isRomeNumericSystem(expression)) {
            expression = convertToArabNumericSystem(expression);
        }
        calculate(expression);
    }

    private String convertToArabNumericSystem(String expression) {
        StringBuilder resultExpression = new StringBuilder();

        for (int i = 0; i < expression.length(); i++) {
            StringBuilder currentNumber = new StringBuilder();

            if (Util.isSeparator(expression.charAt(i)) || Util.isOperator(expression.charAt(i))) {
                resultExpression.append(expression.charAt(i));
            } else {
                while (Util.isSeparator(expression.charAt(i)) || Util.isOperator(expression.charAt(i))) {
                    currentNumber.append(expression.charAt(i));
                    i++;
                }
            }
            resultExpression.append(getDecimalNumber(currentNumber.toString()));
        }
        return resultExpression.toString();
    }

    public double calculate(String expression) {
        StringBuilder postfixNotation = getExpression(expression);
        return count(postfixNotation);
    }

    private StringBuilder getExpression(String expression) {

        StringBuilder postfixNotation = new StringBuilder();
        Stack<Character> operatorStack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {

            if (Util.isSeparator(expression.charAt(i))) { continue; }

            if (Character.isDigit(expression.charAt(i))) {

                while (!Util.isOperator(expression.charAt(i)) &&
                        !Util.isSeparator(expression.charAt(i))) {

                    postfixNotation.append(expression.charAt(i));
                    i++;
                    if (i == expression.length()) { break; }
                }
                postfixNotation.append(" ");
                i--;
            }

            if (Util.isOperator(expression.charAt(i))) {

                if (expression.charAt(i) == '(') {
                    operatorStack.push(expression.charAt(i));
                } else if (expression.charAt(i) == ')') {

                    char currentOperator = operatorStack.pop();

                    while (currentOperator != '(') {
                        postfixNotation.append(Character.toString(currentOperator));
                        postfixNotation.append(" ");
                        currentOperator = operatorStack.pop();
                    }
                } else {
                    if (operatorStack.size() > 0) {
                        if (Util.getPriprity(expression.charAt(i)) <=
                                Util.getPriprity(operatorStack.peek())) {
                            postfixNotation.append(operatorStack.pop().toString());
                            postfixNotation.append(" ");
                        }
                    } else {
                        operatorStack.push(expression.charAt(i));
                    }
                }
            }
        }
        while (operatorStack.size() > 0) {
            postfixNotation.append(operatorStack.pop());
            postfixNotation.append(" ");
        }
        return postfixNotation;
    }

    private double count (StringBuilder postfixNotationExpression) {
        double result = 0;
        Stack<Double> stack = new Stack<>();

        for (int i = 0; i < postfixNotationExpression.length(); i++) {

            if (Character.isDigit(postfixNotationExpression.charAt(i))) {
                StringBuilder number = new StringBuilder();

                while (!Util.isSeparator(postfixNotationExpression.charAt(i)) &&
                        !Util.isOperator(postfixNotationExpression.charAt(i))) {

                    number.append(postfixNotationExpression.charAt(i++));
                    if (i == postfixNotationExpression.length()) { break; }
                }
                stack.push(Double.parseDouble(number.toString()));
                i--;
            } else if (Util.isOperator(postfixNotationExpression.charAt(i))) {
                double firstNumber = stack.pop();
                double secondNumber = stack.pop();

                stack.push(getOperation(firstNumber, postfixNotationExpression.charAt(i), secondNumber));
            }
        }
        return stack.peek();
    }

    private double getOperation(double value1, char operation, double value2) {
        switch (operation) {
            case '+':
                return value1 + value2;
            case '-':
                return value1 - value2;
            case '*':
                return value1 * value2;
            case '/':
                return value1 / value2;
            default:
                System.out.println("Illegal input");
                return 0;
        }
    }

    private double getDecimalNumber(String number) {
        double result = 0;
        final int len = number.length();
        for (int i = 0; i < len - 1; i++) {
            if (getValue(number.charAt(i)) >= getValue(number.charAt(i + 1)))
                result += getValue(number.charAt(i));
            else
                result = result + getValue(number.charAt(i + 1)) - getValue(number.charAt(i));
        }
        result += getValue(number.charAt(len - 1));
        return result;
    }

    private StringBuilder getRomeNumber(double n) {
        int number = (int)n;
        if  (number <= 0) {
            System.out.println("Number couldn't be negative!");
            return new StringBuilder();
        }
        StringBuilder result = new StringBuilder();
        if (number >= 1000) {
            result.append(getRomeNumberPart("M", number/1000));
            number %= 1000;
        }
        if (number >= 500 && number < 900) {
            result.append(getRomeNumberPart("D", number/500));
            number %= 500;
        }
        if (number >= 500) {
            result.append("CM");
            number %= 100;
        }
        if (number >= 100 && number < 400) {
            result.append(getRomeNumberPart("C", number/100));
            number %= 100;
        }
        if (number >= 100) {
            result.append("CD");
            number %= 100;
        }
        if (number >= 50 && number < 90) {
            result.append(getRomeNumberPart("L", number/50));
            number %= 50;
        }
        if (number >= 50) {
            result.append("XC");
            number %= 50;
        }
        if (number >= 10 && number < 40) {
            result.append(getRomeNumberPart("X", number/10));
            number %= 10;
        }
        if (number >= 10) {
            result.append("XL");
            number %= 10;
        }
        if (number >= 5 && number < 9) {
            result.append(getRomeNumberPart("V", number / 5));
            number %= 5;
        }
        if (number >= 5) {
            result.append("V");
            number %= 5;
        }
        if (number >= 1 && number < 4) {
            result.append(getRomeNumberPart("I", number));
            number = 0;
        }
        if (number >= 1) {
            result.append("IV");
        }
        return result;
    }

    private StringBuilder getRomeNumberPart(String symbol, int amountOfSymbols) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < amountOfSymbols; i++) {
            result.append(symbol);
        }
        return result;
    }

    private boolean numbersAreOfDifferentType(String value1, String value2) {
        return (isDecimal(value1) ^ isDecimal(value2));
    }

    private boolean isDecimal(String value) {
        return value.matches("-*[0-9]+.*[0-9]+|[0-9]+");
    }

    /**
     *   I  - 1
     *   IV - 4
     *   V  - 5
     *   IX - 9
     *   X  - 10
     *   XL - 40
     *   L  - 50
     *   XC - 90
     *   C  - 100
     *   CD - 400
     *   D  - 500
     *   CM - 900
     *   M  - 1000
     */
    private int getValue(char symbol) {
        if (symbol == 'I') { return 1; }
        if (symbol == 'V') { return 5; }
        if (symbol == 'X') { return 10; }
        if (symbol == 'L') { return 50; }
        if (symbol == 'C') { return 100; }
        if (symbol == 'D') { return 500; }
        if (symbol == 'M') { return 1000; }
        return -1;
    }
}
