package com.docseeker.news.mapping;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration("newsRecordMappingConfiguration")
public class MappingConfiguration {

    @Bean
    public NewsRecordMapper newsRecordMapper() {
        return new NewsRecordMapper();
    }
}
