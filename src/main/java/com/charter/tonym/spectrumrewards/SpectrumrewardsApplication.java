package com.charter.tonym.spectrumrewards;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "APIs", version = "2.0", description = "Documentation APIs v2.0"))
public class SpectrumrewardsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpectrumrewardsApplication.class, args);
    }

}
