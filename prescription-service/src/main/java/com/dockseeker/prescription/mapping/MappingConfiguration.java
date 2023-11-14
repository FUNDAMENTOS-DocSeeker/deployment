package com.dockseeker.prescription.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("prescriptionRecordMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public PrescriptionRecordMapper prescriptionRecordMapper() {
        return new PrescriptionRecordMapper();
    }
}
