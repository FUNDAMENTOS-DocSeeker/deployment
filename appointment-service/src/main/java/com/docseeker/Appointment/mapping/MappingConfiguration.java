package com.docseeker.Appointment.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("appointmentMappingConfiguration")
public class MappingConfiguration {
  @Bean
  public AppointmentMapper appointmentMapper() {
    return new AppointmentMapper();
  }
}
