package com.net.demo33;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableCaching
@EnableScheduling
public class Demo33Application {

	public static void main(String[] args) {
		SpringApplication.run(Demo33Application.class, args);
	}

}
