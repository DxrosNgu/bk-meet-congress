package com.pe.stmp.one.meetcongresseurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MeetCongressEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MeetCongressEurekaServerApplication.class, args);
	}

}
