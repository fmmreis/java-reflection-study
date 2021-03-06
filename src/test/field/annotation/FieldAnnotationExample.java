package test.field.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.util.Arrays;

public class FieldAnnotationExample {

    public static void main(String[] args) {

        TheClass theClass = new TheClass();
        setField(theClass, "RECO_STRING_FIELD", "AAA");
        setField(theClass, "RECO_DECIMAL_FIELD", new BigDecimal(123.10000000));

        System.out.println(theClass.myStringField);
        System.out.println(theClass.myDecimalField);

    }

    public static void setField(TheClass theClass, String fieldName, Object value) {
        Field[] fields = TheClass.class.getFields();

        for (Field field: fields) {
            Annotation[] annotations = field.getDeclaredAnnotations();
            for(Annotation annotation: annotations){
                MyAnnotation myAnnotation = (MyAnnotation) annotation;
                if(myAnnotation.name().equals(fieldName)) {
                    try {
                        field.set(theClass, value);
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

//        Arrays.stream(fields).forEach(field -> {
//            Annotation[] annotations = field.getDeclaredAnnotations();
//            Arrays.stream(annotations).forEach(annotation -> {
//                if (((MyAnnotation) annotation).name().equals(fieldName))
//                    try {
//                        field.set(theClass, value);
//                    } catch (IllegalAccessException e) {
//                        e.printStackTrace();
//                    }
//            });
//        });

//        Arrays.stream(fields)
//                .forEach(field -> {
//                        Arrays.stream(field.getDeclaredAnnotations()).
//                                filter(annotation -> ((MyAnnotation) annotation).name().equals(fieldName))
//                                .anyMatch(field.set(theClass, value));
//        });

    }
}

class TheClass {
    @MyAnnotation(name="RECO_STRING_FIELD", value="VALUE")
    public String myStringField = null;
    @MyAnnotation(name="RECO_DECIMAL_FIELD", value="VALUE")
    public BigDecimal myDecimalField = null;
}



