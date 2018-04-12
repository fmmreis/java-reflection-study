package test;

import java.lang.annotation.*;

public class ClassAnnotationExample {
    public static void main(String[] args) {

        Annotation[] annotations = TheClass1.class.getAnnotations();

        for(Annotation annotation : annotations){
            if(annotation instanceof MyAnnotation){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                System.out.println("name: " + myAnnotation.name());
                System.out.println("value. " + myAnnotation.value());
            }
        }
    }


}

@MyAnnotation(name="someName", value = "Hello World")
class TheClass1{

}


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface MyAnnotation{
    public String name();
    public String value();
}


