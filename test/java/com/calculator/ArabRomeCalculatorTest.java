package com.calculator;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ArabRomeCalculatorTest {

    @Test
    public void testThatShouldReturnSumOfTwoArabNumbers() {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        String expectedResult = "27.0";
        String actualResult = String.valueOf(calculator.calculate("13 + 14"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatShouldCalculateExpressionWithArabNumbersInBrackets() {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        String expectedResult = "15.0";
        String actualResult = String.valueOf(calculator.calculate("(225 / 15)"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatShouldCalculateComplexExpressionWithArabNumbers() {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        String expectedResult = "1090.0";
        String actualResult = String.valueOf(calculator.calculate("((100 - 10) + (100 * 10))"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatShouldReturnSumOfTwoRomeNumbers() {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        String expectedResult = "XXVII";
        String actualResult = String.valueOf(calculator.calculate("XIII + XIV"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatShouldCalculateExpressionWithRomeNumbersInBrackets() {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        String expectedResult = "XV";
        String actualResult = String.valueOf(calculator.calculate("(CCXXV / XV)"));
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatShouldCalculateComplexExpressionWithRomeNumbers() {
        ArabRomeCalculator calculator = new ArabRomeCalculator();
        String expectedResult = "C";
        String actualResult = String.valueOf(calculator.calculate("((C - X) + (C / X))"));
        assertEquals(expectedResult, actualResult);
    }

}