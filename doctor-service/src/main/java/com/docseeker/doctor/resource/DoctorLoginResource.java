package com.docseeker.doctor.resource;

import lombok.*;

@Getter
@Setter
@With
@AllArgsConstructor
@NoArgsConstructor
public class DoctorLoginResource {
    String dni;
    String password;
}
