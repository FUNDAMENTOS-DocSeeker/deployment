package com.docseeker.doctor.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("DoctorRecordMappingConfiguration")
public class MappingConfiguration {
    @Bean
    public DoctorRecordMapper doctorRecordMapper() {
    return new DoctorRecordMapper();
    }
}
