package com.jpa.gkp.models;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "jpa_students")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Students {
    @Id
    private int studentId;
    private String studentName;
    private String about;
    @OneToOne(mappedBy = "students", cascade = CascadeType.ALL)
    private Laptop laptop;
    @OneToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private List<Address> address;
}
