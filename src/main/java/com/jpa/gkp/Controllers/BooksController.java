package com.jpa.gkp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.gkp.models.Author;
import com.jpa.gkp.models.Books;
import com.jpa.gkp.services.BooksServices;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController

public class BooksController {
    @Autowired
    BooksServices booksServices;

    @PostMapping("/books/create")
    public String postMethodName(@RequestBody Books book) {
        String res = booksServices.createBook(book);
        return res;
    }

    @PostMapping("/author/assign/{bookId}")
    public String assignBooks(@PathVariable Integer bookId, @RequestBody Author author) {
        return booksServices.assignAuthor(bookId, author);
    }

}
