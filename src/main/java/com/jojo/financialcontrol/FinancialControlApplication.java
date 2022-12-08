package com.jojo.financialcontrol;

import com.jojo.financialcontrol.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class FinancialControlApplication {

	public static void main(String[] args) {
		SpringApplication.run(FinancialControlApplication.class, args);
	}

}
