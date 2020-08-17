package com.oracle.tinyurl;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan
public class TinyUrlApplication {

	public static void main(String[] args) {
		SpringApplication.run(TinyUrlApplication.class, args);
	}

}
