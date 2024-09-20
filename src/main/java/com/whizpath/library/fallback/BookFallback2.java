package com.whizpath.library.fallback;

import com.whizpath.library.client.BookClient1;
import com.whizpath.library.client.BookClient2;
import com.whizpath.library.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookFallback2 implements BookClient2 {
    @Override
    public Book getBookData(String id, String name) {
        return new Book(id, name, "Default Book");
    }
}
