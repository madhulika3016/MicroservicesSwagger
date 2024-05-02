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
	public class Microservice4Controller {
		
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

		@GetMapping(value = "/microservice4")
		public String method1() {
			LOG.info("Inside method4");
			
			return "Hello Sleuth and Zipkin";
		}

	}


