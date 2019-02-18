package com.serialization.encoder;

import com.serialization.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import static org.junit.Assert.*;

@RunWith(JUnit4.class)
public class EncoderTest {

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
}