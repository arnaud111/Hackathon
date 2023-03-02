package com.greenring.hackathon.application;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.greenring.hackathon.domain.DomainConfiguration;
import io.vavr.jackson.datatype.VavrModule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@Import({DomainConfiguration.class})
public class ApplicationConfiguration {

    @Bean
    public ObjectMapper objectMapper() {
        return new ObjectMapper().registerModule(new VavrModule());
    }
}
