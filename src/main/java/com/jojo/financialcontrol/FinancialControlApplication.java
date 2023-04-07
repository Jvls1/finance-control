package com.jojo.financialcontrol;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.jojo.financialcontrol.repository")
public class FinancialControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialControlApplication.class, args);
	}

}
