package com.shefzee.currencyconversion;

import com.shefzee.currencyconversion.config.ConversionConfiguration;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.context.event.ApplicationStartingEvent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.EventListener;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.client.RestTemplate;

import java.util.Date;

@SpringBootApplication
@Slf4j
@ConversionConfiguration
public class Application {


	private static final Date INITIALIZED_DATETIME = new Date();

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Bean(name = "validationMessageSource")
	public ResourceBundleMessageSource messageSource(){
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		messageSource.setBasename("messages/validation_messages");
		return messageSource;
	}

	@EventListener(ApplicationStartingEvent.class)
	public void appStartingEvent(){
		log.info("Applicaton Starting, " + INITIALIZED_DATETIME);
	}

	@EventListener(ApplicationReadyEvent.class)
	public void appStartedEvent(){
		Date startedDate = new Date();
		log.info("Application Started, " +startedDate + ", time taken "
				+ ((startedDate.getTime() - INITIALIZED_DATETIME.getTime()))
				+ " ms"
		);
	}

	@Bean
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}

}
