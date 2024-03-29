package com.diego.consumeoc;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumeOpenshiftApplication {
	private static final Logger log = LoggerFactory.getLogger(ConsumeOpenshiftApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(ConsumeOpenshiftApplication.class, args);
	}
	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	@Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {

			ResponseEntity<String> restExchange = restTemplate.exchange(
					"https://bla/integracion/empresa?wsdl", HttpMethod.GET, null, String.class);

			log.info(restExchange.getBody());
		};
	}
}
