package com.meet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.MultipartAutoConfiguration;

@SpringBootApplication
public class WordToPdfConvertApplication {

	public static void main(String[] args) {
		SpringApplication.run(WordToPdfConvertApplication.class, args);
	}

}
