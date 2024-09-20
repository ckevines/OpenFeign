package com.whizpath.library.model.controller;

import com.whizpath.library.model.Book;
import com.whizpath.library.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LibraryController {
    @Autowired
    private LibraryService libraryService;

    @GetMapping(path = "/library/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Book getBookData(@PathVariable("id") String id, @RequestParam("name") String name ) {
        return libraryService.BookData1forId(id, name);
    }
    @GetMapping(path = "/library2/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Book getBookData2(@PathVariable("id") String id, @RequestParam("name") String name ) {
        return libraryService.BookData2forId(id, name);
    }
}
