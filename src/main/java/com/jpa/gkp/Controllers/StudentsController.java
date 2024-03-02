package com.jpa.gkp.Controllers;

import java.util.List;
import org.springframework.web.bind.annotation.RestController;

import com.jpa.gkp.models.Address;
import com.jpa.gkp.models.Laptop;
import com.jpa.gkp.models.Students;
import com.jpa.gkp.services.StudentsServices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentsController {
    @Autowired
    StudentsServices studentsServices;

    @PostMapping("/create/student")
    public String postMethodName(@RequestBody Students students) {
        // Set the student in the addresses
        for (Address address : students.getAddress()) {
            address.setStudents(students);
        }
        if (students.getLaptop() != null) {
            students.getLaptop().setStudents(students);
        }
        return studentsServices.addStudent(students);
    }

    @PostMapping("/create/{studentId}")
    public String postMethodName(@RequestBody Laptop laptop, @PathVariable Integer studentId) {
        studentsServices.assignLaptop(studentId, laptop);
        return "laptop assigned successfully";
    }

    @PostMapping("/createaddress/{studentId}")
    public String postMethodName(@PathVariable Integer studentId, @RequestBody List<Address> address) {
        studentsServices.assignAddress(studentId, address);
        return "student address assigned successfully";
    }

    @GetMapping("/findAll")
    public List<Students> findAllStudents() {
        return studentsServices.getAllSutdents();
    }

}
