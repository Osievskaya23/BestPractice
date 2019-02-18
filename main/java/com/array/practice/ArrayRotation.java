package com.array.practice;

import com.array.practice.manager.Constants;
import com.array.practice.manager.Manager;

import static com.array.practice.manager.Manager.amountIsEqualLength;
import static com.array.practice.manager.Manager.printArray;
import static com.array.practice.manager.Manager.createArray;

import java.util.Scanner;

public class ArrayRotation {

    public StringBuilder arrayRotation() {
        Manager manager = new Manager();

        System.out.println(Constants.ARRAY_ROTATION + Constants.ENTER_ARRAY_SIZE_AND_K);

        Scanner scanner = new Scanner(System.in);

        String[] firstInput = scanner.nextLine().split(" "); // massive size and shift length

        if (!ensureTwoNumbersEntered(firstInput.length)) { return new StringBuilder(); }

        int arrayLength = Integer.parseInt(firstInput[0]);
        int shiftLength = Integer.parseInt(firstInput[1]);

        if (!shiftSmallerThanArray(arrayLength, shiftLength)) { return new StringBuilder(); }

        System.out.println(Constants.ENTER_ARRAY_VALUES + Constants.EXAMPLE_ONE);

        String[] secondInput = scanner.nextLine().split(" ");

        if (!amountIsEqualLength(secondInput.length, arrayLength)) { return new StringBuilder(); }

        int[] arr = createArray(arrayLength, secondInput);

        StringBuilder result = run(arr, shiftLength);

        System.out.println(result);
        return result;
    }

    public StringBuilder run(int[] arr, int shiftLength) {
        return convertArrayToString(shift(arr, shiftLength));
    }

    private StringBuilder convertArrayToString(int[] array) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length - 1; i++) {
            result.append(i);
            result.append(", ");
        }
        result.append(array[array.length - 1]);
        return result;
    }

    private boolean ensureTwoNumbersEntered (int amountOfNumbers) {
        if (amountOfNumbers != 2) {
            System.out.println(Constants.ERROR + Constants.INCORRECT_INPUT);
            return false;
        }
        return true;
    }

    private boolean shiftSmallerThanArray(int arrayLength, int shiftLength) {
        if (arrayLength < shiftLength && arrayLength > 0) {
            System.out.println(Constants.ERROR + Constants.SHIFT_ERROR);
            return false;
        }
        return true;
    }

    private int[] shift(int[] arr, int k) {
        int[] resultArr = new int[arr.length];
        if (resultArr.length - k >= 0) {
            System.arraycopy(arr, k, resultArr, 0, resultArr.length - k);
        }
        if (k >= 0) {
            System.arraycopy(arr, 0, resultArr, resultArr.length - k, k);
        }
        return resultArr;
    }
}
