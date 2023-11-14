package com.dockseeker.prescription.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class UpdatePrescriptionRecordResource {
    private Integer id;
    private Integer patientId;
    private Integer doctorId;
    private String medicineName;
    private String medicineDosage;
    private String medicineDuration;
    private String date;
}
