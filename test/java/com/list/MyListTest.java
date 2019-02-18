package com.list;

import list.MyArrayList;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

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
    public void testThatShouldReturnElementFromTheArrayListByTheGivenIndex() {
        assertEquals(5, (int) integerArrayList.get(2));
        assertEquals("Valia", stringArrayList.get(0));

        assertEquals(5, (int) integerLinkedList.get(2));
        assertEquals("Valia", stringLinkedList.get(0));
    }

    @Test(expected = IndexOutOfBoundsException.class)
    public void testThatShouldReturnExceptionIfGivenIndexIsOutOfBounds() {
        integerArrayList.get(-1);
        stringArrayList.get(17);

        integerLinkedList.get(-1);
        stringLinkedList.get(17);
    }

    @Test
    public void testThatShouldAddElementToTheEndOfTheListAndReturnTrueIfItWasDone() {
        integerArrayList.add(5);
        integerArrayList.add(6);
        assertEquals(6, integerArrayList.size());

        stringArrayList.add("Anton");
        assertEquals(5, stringArrayList.size());

        integerLinkedList.add(5);
        integerLinkedList.add(6);
        assertEquals(6, integerLinkedList.size());

        stringLinkedList.add("Anton");
        assertEquals(5, stringLinkedList.size());
    }

    @Test
    public void testThatShouldRemoveElementFromTheListAndReturnThisElement() {
        assertEquals(1, (int) integerArrayList.remove(0));
        assertEquals(3, integerArrayList.size());

        stringArrayList.remove(3);
        assertEquals("Tolia", stringArrayList.remove(2));
        assertEquals(2, stringArrayList.size());

        assertEquals(1, (int) integerLinkedList.remove(0));
        assertEquals(3, integerLinkedList.size());

        stringLinkedList.remove(3);
        assertEquals("Tolia", stringLinkedList.remove(2));
        assertEquals(2, stringLinkedList.size());
    }

    @Test
    public void testThatShouldReturnSizeOfTheList() {
        assertEquals(4, integerArrayList.size());
        assertEquals(4, stringArrayList.size());

        assertEquals(4, integerLinkedList.size());
        assertEquals(4, stringLinkedList.size());
    }
}