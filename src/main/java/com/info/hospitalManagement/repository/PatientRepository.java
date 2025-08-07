package com.info.hospitalManagement.repository;

import com.info.hospitalManagement.entity.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;
import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Long> {
    Patient getPatientByName(String name);
    Patient getPatientByBirthDate(LocalDateTime birthDate);


    @Query("select p from Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    List<Patient> findAllPatientWithAppointment();


}
