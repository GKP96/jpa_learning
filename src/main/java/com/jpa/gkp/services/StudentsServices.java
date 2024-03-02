package com.jpa.gkp.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jpa.gkp.repository.StudentsRepository;
import com.jpa.gkp.models.Address;
import com.jpa.gkp.models.Laptop;
import com.jpa.gkp.models.Students;

@Service
public class StudentsServices {

    @Autowired
    StudentsRepository studentsRepository;

    public String addStudent(Students student) {
        studentsRepository.save(student);
        return "students created successfully";
    }

    public List<Students> getAllSutdents() {
        return studentsRepository.findAll();
    }

    public void assignLaptop(Integer studentId, Laptop laptop) {
        Students student = studentsRepository.findById(studentId).orElse(null);

        if (student != null) {
            student.setLaptop(laptop);
            laptop.setStudents(student);
            System.out.println("isme aa rha hai ki nahi");
            studentsRepository.save(student);
        }
    }

    public void assignAddress(Integer studentId, List<Address> list) {
        Students students = studentsRepository.findById(studentId).orElse(null);
        if (students != null) {
            List<Address> existingAddresses = students.getAddress();
            if (existingAddresses == null) {
                existingAddresses = new ArrayList<>();

            }
            existingAddresses.addAll(list);
            students.setAddress(existingAddresses);
        }
        studentsRepository.save(students);
    }
}
