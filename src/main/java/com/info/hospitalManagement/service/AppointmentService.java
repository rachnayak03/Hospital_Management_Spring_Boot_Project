package com.info.hospitalManagement.service;

import com.info.hospitalManagement.entity.Appointment;
import com.info.hospitalManagement.entity.Doctor;
import com.info.hospitalManagement.entity.Patient;
import com.info.hospitalManagement.repository.AppointmentRepository;
import com.info.hospitalManagement.repository.DoctorRepository;
import com.info.hospitalManagement.repository.PatientRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AppointmentService {
    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId,Long patientId){
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        Patient patient=patientRepository.findById(patientId).orElseThrow();
        if(appointment.getId()!=null)throw new IllegalArgumentException("Appointment should not have any values");
        appointment.setPatient(patient);
        appointment.setDoctor(doctor);
        patient.getAppointments().add(appointment);
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reassignAppointmentToNewDoctor(Long appointmentId,Long doctorId){
        Appointment appointment=appointmentRepository.findById(appointmentId).orElseThrow();
        Doctor doctor=doctorRepository.findById(doctorId).orElseThrow();
        appointment.setDoctor(doctor);
        doctor.getAppointments().add(appointment);//for bidirectional consistency
        return appointment;
    }
}
