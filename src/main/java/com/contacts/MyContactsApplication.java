package com.contacts;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MyContactsApplication {

	public static void main(String[] args) {
		SpringApplication.run(MyContactsApplication.class, args);
	}

}
