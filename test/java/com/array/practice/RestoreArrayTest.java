package com.array.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class RestoreArrayTest {

    @Test
    public void testThatShouldReplaceNegativeNumbersInArrayToMakeArrayMonotone() {
        RestoreArray restoreArray = new RestoreArray();
        String expectedResult = "1 2 3 4 7 6 5 4 ";
        int[] array = new int[]{1, 2, -1, 4, 7, 6, -2, 4};
        StringBuilder actualResult = restoreArray.run(array);
        assertEquals(actualResult.toString(), expectedResult);
    }
}