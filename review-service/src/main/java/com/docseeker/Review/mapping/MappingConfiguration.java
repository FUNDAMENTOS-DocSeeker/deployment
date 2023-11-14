package com.docseeker.Review.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("mappingConfiguration")
public class MappingConfiguration {
  @Bean
  public EnhancedModelMapper modelMapper() {
    return new EnhancedModelMapper();
  }

  @Bean
  public ReviewMapper reviewMapper() {
    return new ReviewMapper();
  }
}
