package com.info.hospitalManagement.entity;

import com.info.hospitalManagement.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Setter
@Getter
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable=false,length = 40)
    private String name;

    @ToString.Exclude
    private LocalDateTime birthDate;

    @Column(unique = true,nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroup;

    @OneToOne(cascade={CascadeType.ALL},orphanRemoval = true )
    @JoinColumn(name="patient_insurance_id")
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade={CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)

    private List<Appointment> appointments=new ArrayList<>();


}

