package com.docseeker.doctor.domain.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "doctors")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DoctorRecord {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String email;
    private String password;
    private String dni;
    private String birthDate;
    private String phoneNumber;
    private String speciality;
    private String description;
    private Integer experienceYears;
    private Integer patientsAssisted;
    private float doctorFee;
    private String profilePhoto;
}
