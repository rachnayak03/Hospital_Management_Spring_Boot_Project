package com.info.hospitalManagement.entity;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Insurance {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(nullable = false,unique = true,length=50)
    private String policyNumber;

    @Column(nullable = false,length=80)
    private String provider;

    @Column(nullable = false)
    private LocalDateTime validUntill;

    @CreationTimestamp
    @Column(nullable = false,updatable = false)
    private LocalDateTime createdAt;

    @OneToOne(mappedBy = "insurance") //inverse side
    private  Patient patient;
}
