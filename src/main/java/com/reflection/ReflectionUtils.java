package com.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by GURDIT_SINGH on 30-03-2017.
 */
public class ReflectionUtils {

    private Object classObject;
    private Method classMethod;


    public  void createObject(String className){
        try {
            Constructor<?>[] clazz = Class.forName(className).getDeclaredConstructors();
            clazz[0].setAccessible(true);
           classObject= clazz[0].newInstance();
        } catch (ClassNotFoundException e) {
            throw  new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw  new RuntimeException(e);
        } catch (InstantiationException e) {
            throw  new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw  new RuntimeException(e);
        }
    }

    public  void createMethod(String methodName,String... parameters){
        try {

            Class[] parametersArray=new Class[parameters.length];
            for (int i = 0; i < parameters.length; i++) {
               parametersArray[i]= Class.forName(parameters[i]);
            }
           classMethod= classObject.getClass().getMethod(methodName,parametersArray);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    public  Object invokeMethod(Object ... values){
        try {
            return classMethod.invoke(classObject,values);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        }
    }

    public Object getClassObject(){
        return classObject;
    }

    public Method getClassMethod(){
        return classMethod;
    }


}
