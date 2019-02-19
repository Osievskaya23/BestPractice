package com.serialization.encoder;

import com.serialization.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class EncoderTest {

    public static final StringBuilder XML_CODE = new StringBuilder("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
            "<group>\n" +
            "    <name>group 1</name>\n" +
            "    <figures>\n" +
            "        <triangle>\n" +
            "            <name>triangle 1</name>\n" +
            "            <firstSideLength>3</firstSideLength>\n" +
            "            <secondSideLength>4</secondSideLength>\n" +
            "            <thirdSideLength>5</thirdSideLength>\n" +
            "            <square>6.0</square>\n" +
            "        </triangle>\n" +
            "        <circle>\n" +
            "            <PI>3.141592653589793</PI>\n" +
            "            <name>circle 1</name>\n" +
            "            <radius>5</radius>\n" +
            "            <square>78.53981633974483</square>\n" +
            "        </circle>\n" +
            "        <square>\n" +
            "            <name>square 1</name>\n" +
            "            <sideLength>2</sideLength>\n" +
            "            <square>4.0</square>\n" +
            "        </square>\n" +
            "    </figures>\n" +
            "    <groups>\n" +
            "    </groups>\n" +
            "</group>\n");

    public static final StringBuilder JSON_CODE = new StringBuilder("{\n" +
                                            "  \"name\":\"group 1\",\n" +
                                            "  \"figures\":[\n" +
                                            "      {\n" +
                                            "        \"name\":\"triangle 1\",\n" +
                                            "        \"square\":\"6.0\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"PI\":\"circle 1\",\n" +
                                            "        \"square\":\"78.53981633974483\"\n" +
                                            "      },\n" +
                                            "      {\n" +
                                            "        \"name\":\"square 1\",\n" +
                                            "        \"square\":\"4.0\"\n" +
                                            "      }\n" +
                                            "    ],\n" +
                                            "  \"groups\":[\n" +
                                            "    ]\n" +
                                            "}\n");

    Group group;
    Class clazz;

    @Before
    public void init() {
        group = new Group("group 1");
        Figure firstTriangle = new Triangle("triangle 1",3, 4, 5);
        Figure firstCircle = new Circle("circle 1", 5);
        Figure firstSquare = new Square("square 1", 2);
        group.addFigures(firstTriangle, firstCircle, firstSquare);
        clazz = group.getClass();
    }

    @Test
    public void testThatShouldFailIfMethodReturnEmptyStringBuilderWithCodeSerializedToXml() throws IllegalAccessException{
        XmlEncoder encoder = new XmlEncoder();
        StringBuilder result = encoder.serializeToXML(group, clazz, 0);
        if (result.length() == 0) { fail(); }
    }

    @Test
    public void testThatShouldFailIfMethodReturnEmptyStringBuilderWithCodeSerializedToJson() throws IllegalAccessException{
        JsonEncoder encoder = new JsonEncoder();
        StringBuilder result = encoder.serializeToJSON(group, clazz, 0);
        if (result.length() == 0) { fail(); }
    }

    @Test
    public void testThatShouldReturnSerializedXml() throws IllegalAccessException{
        XmlEncoder encoder = new XmlEncoder();
        StringBuilder expectedResult = XML_CODE;
        StringBuilder actualResult = encoder.serializeToXML(group, clazz, 0);
        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testThatShouldReturnSerializedJson() {
        JsonEncoder encoder = new JsonEncoder();
        StringBuilder expectedResult = JSON_CODE;
        StringBuilder actualResult = encoder.serializeToJSON(group, clazz, 0);
        assertEquals(expectedResult, actualResult);
    }
}