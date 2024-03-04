package com.jpa.gkp.Controllers;

import org.springframework.web.bind.annotation.RestController;

import com.jpa.gkp.models.Author;
import com.jpa.gkp.models.Books;
import com.jpa.gkp.repository.AuthorRepository;
import com.jpa.gkp.services.AuthorService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
public class AuthorController {
    @Autowired
    AuthorService authorService;
    @PostMapping("/author/create")
    public String postMethodName(@RequestBody Author author) {
        String res = authorService.createAuthor(author);
        return res;
    }

    @PostMapping("/book/assign/{bookId}")
    public String assignBooks(@PathVariable Integer bookId, @RequestBody List<Books> books) {
        return authorService.assignBooks(bookId, books);
    }
    
}
