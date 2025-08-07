package com.info.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false,length=100)
    private String name;

    @Column(length = 100)
    private String specialization;

    @Column(nullable = false,length=100,unique=true)
    private String email;

     @OneToMany(mappedBy = "doctor")
     private List<Appointment> appointments=new ArrayList<>();

    @ManyToMany(mappedBy="doctors")
    private Set<Department> departments=new HashSet<>();

}
