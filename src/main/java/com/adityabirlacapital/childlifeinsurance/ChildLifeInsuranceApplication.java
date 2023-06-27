package com.adityabirlacapital.childlifeinsurance;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class ChildLifeInsuranceApplication extends SpringBootServletInitializer {

	public static void main(String[] args) {
		SpringApplication.run(ChildLifeInsuranceApplication.class, args);
	}

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder springApplicationBuilder){
		return springApplicationBuilder.sources(ChildLifeInsuranceApplication.class);
	}
}
