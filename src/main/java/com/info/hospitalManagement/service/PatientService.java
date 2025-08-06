package com.info.hospitalManagement.service;

import com.info.hospitalManagement.entity.Patient;
import com.info.hospitalManagement.repository.PatientRepository;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service

@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;
    @Transactional
    public Patient getPatientById(Long id){
         Patient p1=patientRepository.findById(id).orElseThrow();
        Patient p2=patientRepository.findById(id).orElseThrow();
        return p1;

    }
}
