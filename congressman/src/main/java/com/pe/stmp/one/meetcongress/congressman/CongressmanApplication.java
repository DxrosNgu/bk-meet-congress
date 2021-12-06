package com.pe.stmp.one.meetcongress.congressman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@EnableJpaRepositories
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EntityScan( basePackages = "com.pe.stmp.one.meetcongress.congressman.web.model.dao")
public class CongressmanApplication {

    public static void main(String[] args) {
        SpringApplication.run(CongressmanApplication.class, args);
    }

}