package com.pe.stmp.one.meetcongresscongressman;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableEurekaClient
@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@EnableJpaRepositories()
public class CongressmanApplication {

	public static void main(String[] args) {
		SpringApplication.run(CongressmanApplication.class, args);
	}

}
