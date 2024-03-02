package com.jpa.gkp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import com.jpa.gkp.repository.LaptopRepository;
import com.jpa.gkp.repository.StudentsRepository;
import com.jpa.gkp.models.Laptop;

@Service
public class LaptopServices {
    @Autowired
    LaptopRepository laptopRepository;
    @Autowired
    StudentsRepository studentsRepository;

    public List<Laptop> getAllLaptop() {
        return laptopRepository.findAll();
    }

    public String createLaptop(Laptop laptop) {
        // System.out.println(laptop.getBrand() + " " + laptop.getModelNumber());
        laptopRepository.save(laptop);
        return "laptop saved successfully";
    }
}
