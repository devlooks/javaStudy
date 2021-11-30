package org.example;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException {

        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        // @org.example.MyAnnotation(value="shin", number=100) 결과
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
        // 해당 클래스에 선언된 어노테이션만 가져온다.

        // 해당 클래스의 필드에 붙여진 Annotation 가져오기
        Arrays.stream(MyBook.class.getDeclaredFields()).forEach(f-> {
            // f.getAnnotation(); 특정 어노테이션 타입 가져오기
            Arrays.stream(f.getAnnotations()).forEach(System.out::println);
        });

        // 어노테이션에 있는 값도 가져와 참조 할 수 있음
        Arrays.stream(MyBook.class.getDeclaredFields()).forEach(f-> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if (a instanceof MyAnnotation)  {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.value());
                    System.out.println(myAnnotation.number());
                }
            });
        });
    }
}
