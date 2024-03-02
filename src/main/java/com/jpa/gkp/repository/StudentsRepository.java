package com.jpa.gkp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jpa.gkp.models.Students;

public interface StudentsRepository  extends JpaRepository<Students, Integer>{
    
}
