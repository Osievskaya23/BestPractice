package com.array.practice.manager;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class ManagerTest {

    @Test
    public void testThatShouldReturnFalseIfLengthAndAmountOfElementsAreNotEqual() {
        Manager manager = new Manager();
        boolean actualResult = manager.amountIsEqualLength(3, 4);
        boolean actualResult1 = manager.amountIsEqualLength(4, 3);
        assertEquals(false, actualResult);
        assertEquals(false, actualResult1);
    }

    @Test
    public void testThatShouldReturnFalseIfArrayIsNotSorted() {
        Manager manager = new Manager();
        boolean actualResult = manager.isSorted(new String[]{"8", "4", "109", "0"});
        assertEquals(false, actualResult);
    }

    @Test
    public void testThatShouldReturnTrueIfArrayIsSorted() {
        Manager manager = new Manager();
        boolean actualResult = manager.isSorted(new String[]{"8", "44", "109", "10000"});
        assertEquals(true, actualResult);
    }

    @Test
    public void testThatShouldReturnArrayOfIntConvertedFromStrings() {
        Manager manager = new Manager();
        String[] inputArray = new String[]{"1", "2", "3", "4"};
        int[] expectedResult = new int[]{1, 2, 3, 4};
        int[] actualResult = manager.createArray(inputArray.length, inputArray);
        Assert.assertArrayEquals(expectedResult, actualResult);
    }
}
