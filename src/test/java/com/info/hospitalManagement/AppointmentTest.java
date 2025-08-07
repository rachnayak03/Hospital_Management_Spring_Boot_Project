package com.info.hospitalManagement;

import com.info.hospitalManagement.entity.Appointment;
import com.info.hospitalManagement.entity.Insurance;
import com.info.hospitalManagement.entity.Patient;
import com.info.hospitalManagement.service.AppointmentService;
import com.info.hospitalManagement.service.InsuranceService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

@SpringBootTest
public class AppointmentTest {
    @Autowired
    private InsuranceService insuranceService;
    @Autowired
    private AppointmentService appointmentService;
    @Test
    public  void testInsurance(){
        Insurance insurance=Insurance.builder()
                .policyNumber("ICICI_9090")
                .provider("ICICI")
                .validUntill(LocalDateTime.of(2030,7,8,16,36))
                .build();
        Patient patient=insuranceService.assignInsuranceToPatient(insurance,1L);
        System.out.println(patient);

        var newPatient=insuranceService.disaccociateInsuranceFromPatient(patient.getId());
        System.out.println(newPatient);
    }


    @Test
    public void testCreateAppointment(){
        Appointment appointment=Appointment.builder()
                .appointmentTime(LocalDateTime.of(2025,11,5,16,40))
                .reason("appendix")
                .build();
        var newappointment=appointmentService.createNewAppointment(appointment,1L,3L);
        System.out.println(newappointment);

        var reassignedAppointment=appointmentService.reassignAppointmentToNewDoctor(newappointment.getId(),3L);
        System.out.println(reassignedAppointment);
    }
}
