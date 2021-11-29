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
        // 클래스 로딩이 끝날때, 힙영역에 들어감

        // 타입을 통한 접근
        Class<Book> bookClass = Book.class;

        // 인스턴스를 통한 접근 방식
        Book book = new Book();
        Class<? extends Book> aClass = book.getClass();

        // 풀(Full) 클래스 명을 통한 접근 -> 문자열 없으면 ClassNotFoundException
        Class<?> aClass1 = Class.forName("org.example.Book");

        // 정의된 필드가 d밖에 안나옴. 왜일까?
        // 해당 getFields()는 퍼블릭한 필드만 가져온다.
        Arrays.stream(bookClass.getFields()).forEach(System.out::println);

        // 선언된 모든 필드 가져오기
        // 특정 필드 가져오기
        //Arrays.stream(bookClass.getField()).forEach(System.out::println);
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);

        // field의 값을 가져오고 싶을때
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {

                f.setAccessible(true); // 접근 불가능한필드 (접근지시자)무시

                // 에러 발생, 접근 불가능한 필드 접근 시도
                f.get(book);
                System.out.printf("%s %s\n", f, f.get(book));
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        });

        // 인스턴스의 메서드 접근
        Arrays.stream(bookClass.getMethods()).forEach(System.out::println);

        // 인스턴스의 생성자 접근
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        // 인스턴스의 상위 클래스 접근
        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);

        // 인스턴스의 인터페이스 접근
        Arrays.stream(MyBook.class.getInterfaces()).forEach(System.out::println);

        // 인스턴스의 필드의 접근지시자 타입 확인
        Arrays.stream(Book.class.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
            System.out.println(Modifier.isProtected(modifiers));
        });

        // 인스턴스의 메서드 접근 방법
        Arrays.stream(Book.class.getMethods()).forEach(m ->{
            int modifiers = m.getModifiers();
            // Methods들의 정보 확인 가능(m.
        });

    }
}
