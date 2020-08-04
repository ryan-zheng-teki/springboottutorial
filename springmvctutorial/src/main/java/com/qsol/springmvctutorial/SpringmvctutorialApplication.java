package com.qsol.springmvctutorial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@ServletComponentScan
@SpringBootApplication
public class SpringmvctutorialApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringmvctutorialApplication.class, args);
	}

}
