package com;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import brave.sampler.Sampler;
import ch.qos.logback.classic.Logger;

	
	@RestController
	public class Microservice3Controller {
		
		@Autowired
		RestTemplate restTemplate;

		@Bean
		public RestTemplate getRestTemplate() {
			return new RestTemplate();
		}

		@Bean
		public Sampler defaultSampler() {
			return Sampler.ALWAYS_SAMPLE;
		}

		private final Logger LOG = (Logger) LoggerFactory.getLogger(this.getClass());

		@GetMapping(value = "/microservice3")
		public String method3() {
			LOG.info("Inside method3");
			String baseUrl = "http://localhost:8083/microservice4";
			
			try {
				Thread.sleep(1000);
			} catch (Exception ex) {

			}
			String response = (String) restTemplate.exchange(baseUrl, HttpMethod.GET, null, String.class).getBody();
			LOG.info("The response recieved by method3 is " + response);
			return response;
		}

	}


