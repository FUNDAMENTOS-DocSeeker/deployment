package com.docseeker.doctor.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DoctorRecordResource {
    private String id;
    private String name;
    private String email;
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
