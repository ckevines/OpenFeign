package com.whizpath.library.service;

import com.whizpath.library.client.BookClient1;
import com.whizpath.library.client.BookClient2;
import com.whizpath.library.model.Book;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LibraryService {

    private final BookClient1 bookClient1;
    private final BookClient2 bookClient2;
    public Book BookData1forId(String id, String name) {
        return bookClient1.getBookData(id, name);
    }
    public Book BookData2forId(String id, String name) {
        return bookClient2.getBookData(id, name);
    }
}
