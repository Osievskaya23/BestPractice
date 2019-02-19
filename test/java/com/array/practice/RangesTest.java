package com.array.practice;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.assertEquals;

@RunWith(JUnit4.class)
public class RangesTest {

    @Test
    public void testThatShouldFindMonotoneAreasInArrayAndPutItInSquareBrackets() {
        Ranges ranges = new Ranges();
        String expectedResult = "[1 3][5][8 10][13 16]";
        int[] array = new int[]{1, 2, 3, 5, 8, 9, 10, 13, 14, 15, 16};
        StringBuilder  actualResult = ranges.findRanges(array);
        assertEquals(actualResult.toString(), expectedResult);
    }

    @Test
    public void secondTestThatShouldFindMonotoneAreasInArrayAndPutItInSquareBrackets() {
        Ranges ranges = new Ranges();
        String expectedResult = "[1 3][5][7]";
        int[] array = new int[]{1, 2, 3 ,5, 7};
        StringBuilder  actualResult = ranges.findRanges(array);
        assertEquals(actualResult.toString(), expectedResult);
    }
}
