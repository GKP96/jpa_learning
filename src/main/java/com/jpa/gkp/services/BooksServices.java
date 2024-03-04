package com.jpa.gkp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.gkp.models.Author;
import com.jpa.gkp.models.Books;
import com.jpa.gkp.repository.BooksRepository;

@Service
public class BooksServices {
    @Autowired
    BooksRepository booksRepository;

    public String createBook(Books book){
        booksRepository.save(book);
        return "book saved successfully";
    }

    public String assignAuthor(Integer bookId, Author author){
        Books books = booksRepository.findById(bookId).orElse(null);
        if(books == null){
            return "book not found";
        }
        books.setAuthor(author);
        booksRepository.save(books);
        return "author assigned successfully";
    }
}
