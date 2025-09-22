package com.HospitalManagementSystem.service;


import com.HospitalManagementSystem.entity.Patient;
import com.HospitalManagementSystem.repository.PatientRepository;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PatientService {
    private final PatientRepository patientRepository;

    @Transactional
    public Patient getPatientById(Long id) {
      Patient p3 = patientRepository.findById(id).orElseThrow();
      Patient p2 = patientRepository.findById(id).orElseThrow();
        System.out.println(p3=p2);
           p3.setName("yoyo");
            patientRepository.save(p3);
      return p3;

    }

}
