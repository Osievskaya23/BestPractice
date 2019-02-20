package com.list;

import static org.junit.Assert.assertEquals;

import list.MyArrayList;
import org.junit.Before;
import org.junit.Test;

public class MyListTest {

    private MyList<Integer> integerArrayList = new MyArrayList<>();
    private MyList<String> stringArrayList = new MyArrayList<>();

    private MyList<Integer> integerLinkedList = new MyLinkedList<>();
    private MyList<String> stringLinkedList = new MyLinkedList<>();

    @Before
    public void init() {
        integerArrayList.add(1);
        integerArrayList.add(3);
        integerArrayList.add(5);
        integerArrayList.add(7);

        stringArrayList.add("Valia");
        stringArrayList.add("Dmitriy");
        stringArrayList.add("Tolia");
        stringArrayList.add("Max");

        integerLinkedList.add(1);
        integerLinkedList.add(3);
        integerLinkedList.add(5);
        integerLinkedList.add(7);

        stringLinkedList.add("Valia");
        stringLinkedList.add("Dmitriy");
        stringLinkedList.add("Tolia");
        stringLinkedList.add("Max");
    }

    @Test
    public void testThatShouldReturnIntFromTheArrayListByTheGivenIndex() {
        assertEquals(5, (int) integerArrayList.get(2));
    }

    @Test
    public void testThatShouldReturnStringFromTheArrayListByTheGivenIndex() {
        assertEquals("Valia", stringArrayList.get(0));
    }

    @Test
    public void testThatShouldReturnIntFromTheLinkedListByTheGivenIndex() {
        assertEquals(5, (int) integerLinkedList.get(2));
    }

    @Test
    public void testThatShouldReturnStringFromTheLinkedListByTheGivenIndex() {
        assertEquals("Valia", stringLinkedList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatShouldReturnExceptionIfGivenIndexOfArrayListIsNegative() {
        integerArrayList.get(-1);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatShouldReturnExceptionIfGivenIndexOfArrayListIsGreaterThanSizeOfList() {
        stringArrayList.get(17);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatShouldReturnExceptionIfGivenIndexOfLinkedListIsNegative() {
        integerLinkedList.get(-5);
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatShouldReturnExceptionIfGivenIndexOfLinkedListIsGreaterThanSizeOfList() {
        stringLinkedList.get(1000);
    }

    @Test
    public void testThatShouldAddIntToTheEndOfTheArrayListAndReturnTrueIfItWasDone() {
        integerArrayList.add(5);
        integerArrayList.add(6);
        assertEquals(6, integerArrayList.size());
    }

    @Test
    public void testThatShouldAddStringToTheEndOfTheListAndReturnTrueIfItWasDone() {
        stringArrayList.add("Anton");
        stringArrayList.add("Max");
        assertEquals(6, stringArrayList.size());
    }

    @Test
    public void testThatShouldAddIntToTheEndOfTheLinkedListAndReturnTrueIfItWasDone() {
        integerLinkedList.add(23);
        integerLinkedList.add(14);
        integerLinkedList.add(1);
        assertEquals(7, integerLinkedList.size());
    }

    @Test
    public void testThatShouldAddStringToTheEndOfTheLinkedListAndReturnTrueIfItWasDone() {
        stringLinkedList.add("Anton");
        assertEquals(5, stringLinkedList.size());
    }

    @Test
    public void testThatShouldRemoveIntFromTheArrayListAndReturnThisInt() {
        assertEquals(1, (int) integerArrayList.remove(0));
        assertEquals(3, integerArrayList.size());
    }

    @Test
    public void testThatShouldRemoveStringFromTheArrayListAndReturnThisString() {
        stringArrayList.remove(3);
        assertEquals("Tolia", stringArrayList.remove(2));
        assertEquals(2, stringArrayList.size());
    }

    @Test
    public void testThatShouldRemoveIntFromTheLinkedListAndReturnThisInt() {
        assertEquals(1, (int) integerLinkedList.remove(0));
        assertEquals(3, integerLinkedList.size());
    }

    @Test
    public void testThatShouldRemoveStringFromTheLinkedListAndReturnThisString() {
        stringLinkedList.remove(3);
        assertEquals("Tolia", stringLinkedList.remove(2));
        assertEquals(2, stringLinkedList.size());
    }

    @Test
    public void testThatShouldReturnSizeOfTheIntArrayList() {
        assertEquals(4, integerArrayList.size());
    }

    @Test
    public void testThatShouldReturnSizeOfTheStringArrayList() {
        assertEquals(4, stringArrayList.size());
    }

    @Test
    public void testThatShouldReturnSizeOfTheIntLinkedList() {
        assertEquals(4, integerLinkedList.size());
    }

    @Test
    public void testThatShouldReturnSizeOfTheStringLinkedList() {
        assertEquals(4, stringLinkedList.size());
    }
}