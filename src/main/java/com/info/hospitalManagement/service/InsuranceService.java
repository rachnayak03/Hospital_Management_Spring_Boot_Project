package com.info.hospitalManagement.service;

import com.info.hospitalManagement.entity.Insurance;
import com.info.hospitalManagement.entity.Patient;
import com.info.hospitalManagement.repository.InsuranceRepository;
import com.info.hospitalManagement.repository.PatientRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class InsuranceService {
    private final InsuranceRepository insuranceRepository;
    private final PatientRepository patientRepository;
    @Transactional
    public Patient assignInsuranceToPatient(Insurance insurance, Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id:"+patientId));
        patient.setInsurance(insurance);
        insurance.setPatient(patient);
        return patient;

    }
    @Transactional
    public Patient disaccociateInsuranceFromPatient(Long patientId){
        Patient patient=patientRepository.findById(patientId).orElseThrow(()->new EntityNotFoundException("Patient not found with id:"+patientId));
        patient.setInsurance(null);
        return patient;
    }
}
