package com.array.practice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class ArrayRotationTest {

    @Test
    public void testThatShouldMoveFirstElementsInArrayToTheEnd() {
        ArrayRotation arrayRotation = new ArrayRotation();
        String expectedResult = "4, 5, 6, 7, 1, 2, 3";
        StringBuilder actualResult = arrayRotation.run(new int[]{1, 2, 3, 4, 5, 6, 7}, 3);
        assertEquals(actualResult.toString(), expectedResult);
    }
}
