package org.example.di;

import org.junit.Assert;
import org.junit.Test;

public class ContainerServiceTest {

    @Test
    public void getObject_BookRepository() {
        BookRepository bookRepository = ContainerService.getObject(BookRepository.class);

        Assert.assertNotNull(bookRepository);
    }

    @Test
    public void getObject_BookService() {
        BookService bookService = ContainerService.getObject(BookService.class);

        Assert.assertNotNull(bookService);
        Assert.assertNotNull(bookService.bookRepository);
    }
}
