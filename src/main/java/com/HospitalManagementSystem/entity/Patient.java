package com.HospitalManagementSystem.entity;
import com.HospitalManagementSystem.entity.type.BloodGroupType;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@ToString
@Getter
@Setter
@Table(
        name = "patient_tb",
        uniqueConstraints = {
              //  @UniqueConstraint(name = "unique_patient_email", columnNames = {"email"}),
                @UniqueConstraint(name = "unique_patient_name_birthdate", columnNames = {"name", "birthdate"})
        },

             indexes = {
                @Index(name = " idx_patient_birth_date", columnList = "birthdate")}
)

public class Patient{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false, length = 50)
    private String name;

   // @ToString.Exclude
    private LocalDate birthdate;

    @Column(unique = true, nullable = false)
    private String email;

    private String gender;

    @CreationTimestamp
    @Column(  updatable = false)
    private LocalDateTime createdAt;

    @Enumerated(EnumType.STRING)
    private BloodGroupType bloodGroupType;

    @OneToOne(cascade ={CascadeType.ALL}, orphanRemoval = true)
    @JoinColumn(name = " patient_insurance_id")//owing side
    private Insurance insurance;

    @OneToMany(mappedBy = "patient",cascade = {CascadeType.REMOVE},orphanRemoval = true,fetch = FetchType.EAGER)
    private List<Appointment> appointments = new ArrayList<>();

}

