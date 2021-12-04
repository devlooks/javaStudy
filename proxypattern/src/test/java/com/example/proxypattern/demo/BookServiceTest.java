package com.example.proxypattern.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import static org.junit.jupiter.api.Assertions.*;

public class BookServiceTest {
    // real Subject
//   BookService bookService = new DefualtBookService();

    // proxy
//    BookService bookService = new BookServiceProxy(new DefualtBookService());


    // 제약사항, 클래스 기반의 프록시 만들수 없다.
    BookService bookService = (BookService) Proxy.newProxyInstance(BookService.class.getClassLoader(), new Class[]{BookService.class},

            // 유연하지 않은 InvacationHandler..
            // 지속적으로 커질 가능성이 있다.
            new InvocationHandler() {

                // real Subject
                BookService bookService = new DefualtBookService();

                @Override
                public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                    // 메서드 분기 주기
                    if (method.getName().equals("rent")) {
                        System.out.println("aaaa");
                        Object invoke = method.invoke(bookService, args);
                        System.out.println("bbbb");
                        return invoke;
                    }

                    return method.invoke(bookService, args);
                 }
    });

    @Test
    public void di() {
        Book book = new Book();
        book.setTitle("spring");
        bookService.rent(book);
        bookService.returnBook(book);
    }
}