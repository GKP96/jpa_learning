package com.jpa.gkp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.gkp.models.Books;

public interface BooksRepository extends JpaRepository<Books, Integer>{
    
}
