package com.example.proxypattern.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class BookServiceProxy implements BookService{

    BookService bookService;

    public BookServiceProxy(BookService bookService) {
        this.bookService = bookService;
    }

    @Override
    public void rent(Book book) {
//        리얼서브젝트를 호출하면서 부가 기능 제공 여지 제공
//        System.out.println("aaaaa");
//        bookService.rent(book);
//        System.out.println("bbbb");

//        접근 제한시 그냥 리얼서브젝트를 호출 하지 안하으면 된다.
        System.out.println("rent : hibernate");
    }

    @Override
    public void returnBook(Book book) {
        System.out.println("aaaa");
        bookService.returnBook(book);
    }
}
