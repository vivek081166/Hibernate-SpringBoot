package com.bookstore.controller;

import com.bookstore.entity.Author;
import com.bookstore.service.BookstoreService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookstoreController {

    private final BookstoreService bookstoreService;

    public BookstoreController(BookstoreService bookstoreService) {
        this.bookstoreService = bookstoreService;
    }

    @GetMapping("/authors/{page}/{size}")
    public Page<Author> fetchAuthors(@PathVariable int page, @PathVariable int size) {

        return bookstoreService.fetchNextPage(page, size);
    }
    
    @GetMapping("/authors")
    // Request example: http://localhost:8080/authors?page=1&size=3&sort=name,desc
    public Page<Author> fetchAuthors(Pageable pageable) {

        return bookstoreService.fetchNextPagePageable(pageable);
    }
}
