package com.example.magazine;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Slf4j
@SpringBootApplication
public class MagazineApplication {
	public static void main(String[] args) {
		SpringApplication.run(MagazineApplication.class, args);

		log.info("main()");
	}
}