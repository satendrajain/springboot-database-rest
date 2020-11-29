package com.assesment;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StartApplication {

	private static final Logger log = LoggerFactory.getLogger(StartApplication.class);

	@Autowired
	private ModuleRepository moduleRepository;
	@Autowired
	private ServiceRepository serviceRepository;
	@Autowired
	private ServiceAuditRepository serviceAuditRepository;

	public static void main(String[] args) {
		System.setProperty("server.servlet.context-path", "/myTest");
		SpringApplication.run(StartApplication.class, args);
	}

}