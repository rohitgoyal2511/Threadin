package com.example.threadin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@SpringBootApplication
@EnableJpaAuditing
@ComponentScan
public class ThreadinApplication {

	public static void main(String[] args) {
		SpringApplication.run(ThreadinApplication.class, args);
	}
	
	@Bean
	public LocalValidatorFactoryBean validator(MessageSource messageSource) {
	    LocalValidatorFactoryBean validatorFactoryBean = new LocalValidatorFactoryBean();
	    validatorFactoryBean.setValidationMessageSource(messageSource);
	    return validatorFactoryBean;
	}
}
