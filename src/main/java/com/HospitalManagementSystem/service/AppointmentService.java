package com.HospitalManagementSystem.service;

import com.HospitalManagementSystem.entity.Appointment;
import com.HospitalManagementSystem.entity.Doctor;
import com.HospitalManagementSystem.entity.Patient;
import com.HospitalManagementSystem.repository.AppointmentRepository;
import com.HospitalManagementSystem.repository.DoctorRepository;
import com.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.data.repository.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Service
@RequiredArgsConstructor
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final DoctorRepository doctorRepository;
    private final PatientRepository patientRepository;

    @Transactional
    public Appointment createNewAppointment(Appointment appointment, Long doctorId, Long patientId) {
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();

        Patient patient = patientRepository.findById(patientId)
                .orElseThrow();

        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        if (appointment.getId() != null) throw new IllegalArgumentException("Appointment already exists");
        appointment.setDoctor(doctor);
        appointment.setPatient(patient);

        patient.getAppointments().add(appointment);

        // save appointment
        return appointmentRepository.save(appointment);
    }

    @Transactional
    public Appointment reAssignAppointmentToAnotherDoctor(Long appointmentId, Long doctorId) {
        // Appointment fetch karo
        Appointment appointment = appointmentRepository.findById(appointmentId)
                .orElseThrow();

        // Doctor fetch karo
        Doctor doctor = doctorRepository.findById(doctorId)
                .orElseThrow();

        // Appointment ka doctor update karo
        appointment.setDoctor(doctor);

        doctor.getAppointments().add(appointment);


        // Save aur return karo
        return appointmentRepository.save(appointment);
    }

}

