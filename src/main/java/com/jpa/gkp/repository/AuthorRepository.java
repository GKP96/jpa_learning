package com.jpa.gkp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.gkp.models.Author;

public interface AuthorRepository extends JpaRepository<Author, Integer> {

}
