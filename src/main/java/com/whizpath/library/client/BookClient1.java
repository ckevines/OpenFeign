package com.whizpath.library.client;

import com.whizpath.library.config.BookClientConfig1;
import com.whizpath.library.fallback.BookFallback1;
import com.whizpath.library.model.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Component
@FeignClient(
        name = "${book-service-client1.name}",
        url = "${book-service-client1.domain-url}",
    configuration = BookClientConfig1.class,
        fallback = BookFallback1.class
)
public interface BookClient1 {

    @GetMapping(path = "${book-service-client1.retrieve-book.url}")
    Book getBookData(@PathVariable("id") String id, @RequestParam("name") String name );
}