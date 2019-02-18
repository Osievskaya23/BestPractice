package com.array.practice;

import static com.array.practice.manager.Constants.ENTER_ARRAY_SIZE;
import static com.array.practice.manager.Constants.ENTER_ARRAY_VALUES;
import static com.array.practice.manager.Constants.RESTORE_ARRAY;
import static com.array.practice.manager.Constants.EXAMPLE_TWO;
import static com.array.practice.manager.Manager.amountIsEqualLength;
import static com.array.practice.manager.Manager.printArray;
import static com.array.practice.manager.Manager.createArray;

import java.util.Arrays;
import java.util.Scanner;

class RestoreArray {
    public void restoreArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.println(RESTORE_ARRAY + ENTER_ARRAY_SIZE);

        int arrLength = Integer.parseInt(scanner.nextLine());

        System.out.println(ENTER_ARRAY_VALUES + EXAMPLE_TWO);

        String[] values = scanner.nextLine().split(" ");

        if(!amountIsEqualLength(arrLength, values.length)) return;

        printArray(findNegativeInt(createArray(arrLength, values)));

    }

    public StringBuilder run(int[] arr) {
        StringBuilder result = new StringBuilder();
        int[] array = findNegativeInt(arr);
        for (int i : array) {
            result.append(i);
            result.append(" ");
        }
        return result;
    }

    private int[] findNegativeInt(int[] arr) {
        int[] resultArr = Arrays.copyOf(arr, arr.length);
        for (int i = 1; i < arr.length - 1; i++) {
            if (arr[i] < 0) {
                resultArr[i] = (arr[i - 1] + arr[i + 1]) / 2;
            }
        }
        return resultArr;
    }
}
