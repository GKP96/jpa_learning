package com.jpa.gkp.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

import com.jpa.gkp.services.LaptopServices;
import com.jpa.gkp.models.Laptop;
import com.jpa.gkp.models.Students;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/laptop")
public class LaptopController {
    @Autowired
    LaptopServices laptopServices;

    @GetMapping("/getAll")
    public List<Laptop> getMethodName() {
        return laptopServices.getAllLaptop();
    }

    @PostMapping("/create")
    public String createLaptop(@RequestBody Laptop laptop) {
        return laptopServices.createLaptop(laptop);
    }

}
