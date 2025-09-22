package com.HospitalManagementSystem.repository;

import com.HospitalManagementSystem.dto.BloodGroupCountResponseEntity;
import com.HospitalManagementSystem.entity.Patient;
import com.HospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.criteria.From;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.awt.print.Pageable;
import java.time.LocalDate;
import java.util.List;


public interface PatientRepository extends JpaRepository<Patient, Long> {


    Patient findByName(String sachin);
    List<Patient> findByBirthdateOrEmail(LocalDate birthdate, String email);


    List<Patient> findByBirthdateBetween(LocalDate startDate, LocalDate endDate);

    List<Patient> findByNameContaining(String query);

    @Query("SELECT p FROM Patient p where p.bloodGroupType = ?1")
    List<Patient> findBloodGroup(@Param("bloodGroupType") BloodGroupType bloodGroupType);

    List<Patient> findByBloodGroupType(BloodGroupType bloodGroupType);

    @Query("SELECT p FROM Patient p where p.birthdate> :birthDate ")
    List<Patient> findByBornAfterDate(@Param("birthDate") LocalDate birthdate);


    @Query("SELECT new com.HospitalManagementSystem.dto.BloodGroupCountResponseEntity(p.bloodGroupType, COUNT(p)) " +
            "FROM Patient p GROUP BY p.bloodGroupType")
    List<BloodGroupCountResponseEntity> countEachBloodGroupType();

    @Query(value = "select * from patient_tb", nativeQuery = true )
    Page<Patient> findAllPatients(PageRequest pageRequest);

    @Modifying
    @Transactional
    @Query("UPDATE Patient p SET p.name = :name WHERE p.id = :id")
    int updateNameWithId(@Param("id") Long id, @Param("name") String name);

   // @Query("select p from Patient p LEFT JOIN FETCH p.appointments a LEFT JOIN FETCH a.doctor")
    @Query("select p from Patient p LEFT JOIN FETCH p.appointments ")
    List<Patient> findAllPatientWithAppointment();

}
