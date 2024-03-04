package com.jpa.gkp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.gkp.models.Author;
import com.jpa.gkp.models.Books;
import com.jpa.gkp.repository.AuthorRepository;

@Service
public class AuthorService {
    @Autowired
    AuthorRepository authorRepository;

    public String createAuthor(Author author) {
        authorRepository.save(author);
        return "book saved successfully";
    }

    public String assignBooks(Integer authorId, List<Books> list) {
        Author author = authorRepository.findById(authorId).orElse(null);
        if (author != null) {
            List<Books> books = author.getBookList();
            if (books == null) {
                books = new ArrayList<Books>();
            }
            books.addAll(list);

            author.setBookList(books);
        }
        authorRepository.save(author);
        return "author assigned successfully";
    }

}
