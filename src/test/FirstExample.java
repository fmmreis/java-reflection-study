package test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class FirstExample {

    public static void main(String[] args) {

        Class myObjectClass = MyObject.class;
        Constructor[] constructors =  myObjectClass.getConstructors();
        Field[] fields = myObjectClass.getFields();
        Method[] methods = myObjectClass.getMethods();

        System.out.println("Full class name : " + myObjectClass.getName());
        System.out.println("Simple class name: " + myObjectClass.getSimpleName());

        for (Constructor constructor : constructors) {
            System.out.println("Constructor name: " + constructor.toString());
        }

        for (Field field : fields) {
            System.out.println("Field name: " + field.getName() + " " + field.getType());
        }

        for (Method method : methods) {
            System.out.println("Method name: " + method.getName());
        }

        //------------------------------------------------------------------------------
        MyObject myObject = new MyObject();
        try {
            Field field = myObjectClass.getField("lastName"); // field private
            field.set(myObject, "Reis");
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        try {
            Method method = myObjectClass.getMethod("setFirstName", new Class[]{String.class});
            method.invoke(myObject, "Fernando");
        } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        System.out.println(myObject.getFirstName() +  " " +  myObject.getLastName());
        //------------------------------------------------------------------------------
    }
}
