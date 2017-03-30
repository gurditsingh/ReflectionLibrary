package com.reflection;

import org.junit.Assert;
import org.junit.Test;

/**
 * Created by GURDIT_SINGH on 30-03-2017.
 */
public class ReflectionUtilsTest {


    @Test
      public void itShouldCreateObjectAndInvokeMethod(){

        //Given
        ReflectionUtils reflectionUtils = new ReflectionUtils();

        //When
        reflectionUtils.createObject("com.dummy.testing.DummyPerson");
        reflectionUtils.createMethod("getName","java.lang.String");

        //Then
        Assert.assertEquals("guri",reflectionUtils.invokeMethod("guri"));

    }


    @Test
    public void itShouldCreateObjectAndInvokeMethodWithCustomParams(){

        //Given
        ReflectionUtils person = new ReflectionUtils();
        ReflectionUtils dummy = new ReflectionUtils();

        //When
        person.createObject("com.dummy.testing.DummyPerson");
        person.createMethod("getName", "java.lang.String");

        dummy.createObject("com.dummy.testing.DummyClass");
        dummy.createMethod("getDummyValue", "com.dummy.testing.DummyPerson");

        //Then
        Assert.assertEquals("dummyValue",dummy.invokeMethod(person.getClassObject()));

    }
}
