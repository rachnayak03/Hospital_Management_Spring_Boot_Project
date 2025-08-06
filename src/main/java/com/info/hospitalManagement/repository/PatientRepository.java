package com.info.hospitalManagement.repository;

import com.info.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient getPatientByName(String name);
    Patient getPatientByBirthDate(LocalDateTime birthDate);
}
