package test;

import java.lang.annotation.*;
import java.lang.reflect.Method;

public class MethodAnnotationExample {

    public static void main(String[] args) {
        try {
            //Method method = TheClass2.class.getMethod("doSomething");
            Annotation[] annotations = TheClass2.class.getMethod("doSomething").getAnnotations();
            for(Annotation annotation : annotations){
                if (annotation instanceof MyMethodAnnotation) {
                    MyMethodAnnotation myAnnotation = (MyMethodAnnotation) annotation;
                    System.out.println("name: " + myAnnotation.name());
                    System.out.println("value: " + myAnnotation.value());
                }
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}


class TheClass2{
    @MyMethodAnnotation(name = "someName", value = "Hello World")
    public void doSomething(){}
}

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface MyMethodAnnotation{
    public String name();
    public String value();
}