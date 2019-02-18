package com.sorting;

import com.algoritms.sorting.merge.sort.MergeSort;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

@RunWith(JUnit4.class)
public class MergeSortTest {

    @Test
    public void testThatShouldReturnSortedArray() {
        int[] array1 = {12, 11, 13, 5, 6, 7};
        int[] array2 = {20, 5, 107, 8, 45, 23, 34, 98, 12};
        int[] array3 = {21, 40, 56, 5, 19, 18, 7, 19, 147, 248, 34};

        int[] expectedResult1 = new int[]{5, 6, 7, 11, 12, 13};
        int[] expectedResult2 = new int[]{5, 8, 12, 20, 23, 34, 45, 98, 107};
        int[] expectedResult3 = new int[]{5, 7, 18, 19, 19, 21, 34, 40, 56, 147, 248};

        MergeSort.sort(array1, 0, array1.length - 1);
        MergeSort.sort(array2, 0, array2.length - 1);
        MergeSort.sort(array3, 0, array3.length - 1);

        Assert.assertArrayEquals(expectedResult1, array1);
        Assert.assertArrayEquals(expectedResult2, array2);
        Assert.assertArrayEquals(expectedResult3, array3);
    }
}