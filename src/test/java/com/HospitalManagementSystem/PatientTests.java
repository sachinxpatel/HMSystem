package com.HospitalManagementSystem;

import com.HospitalManagementSystem.dto.BloodGroupCountResponseEntity;
import com.HospitalManagementSystem.entity.Patient;
import com.HospitalManagementSystem.entity.type.BloodGroupType;
import com.HospitalManagementSystem.service.PatientService;
import com.HospitalManagementSystem.repository.PatientRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;

@SpringBootTest
public class PatientTests {

    @Autowired
    private PatientRepository patientRepository;

    @Autowired
    private PatientService patientService;

    @Test
    public void testPatientRepository() {

        List<Patient> patientList = patientRepository.findAllPatientWithAppointment();
        System.out.println(patientList);

    }

    @Test
    public void testTransactionMethods() {
        //Patient  patient = patientService.getPatientById(1L);

        //  Patient patient =  patientRepository.findById(1L).orElseThrow(() ->
        // new EntityNotFound testTransactionMethods() {

        // Patient patient = patientRepository.findByName("Sachin");

        // List <Patient> patientList = patientRepository.findByBirthdateOrEmail(LocalDate.of(2005,05,15) ,
        // "shivani.p@gmail.com");

        // List<Patient> patientList = patientRepository.findByBornAfterDate(  LocalDate.of( 2000, 02,12));

        Page<Patient> patientPage = patientRepository.findAllPatients(PageRequest.of(0, 2, Sort.by(Sort.Direction.ASC, "name")));

        for (Patient patient : patientPage.getContent()) {
            System.out.println(patient);
        }


//
//      List<Object[]> bloodGroupList = patientRepository.countEachBloodGroupType();
//      for (Object[] bloodGroup : bloodGroupList) {
//          System.out.println(bloodGroup[0] + " " + bloodGroup[1]);
//      }
//        int rowsUpdated = patientRepository.updateNameWithId(3L, "siva");
//        System.out.println(rowsUpdated);

//        List<BloodGroupCountResponseEntity> bloodGroupList= patientRepository.countEachBloodGroupType();
//        for (BloodGroupCountResponseEntity bloodGroupCountResponse: bloodGroupList) {
//            System.out.println(bloodGroupCountResponse);
//        }
    }
}