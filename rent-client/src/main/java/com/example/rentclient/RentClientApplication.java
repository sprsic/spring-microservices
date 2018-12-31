package com.example.rentclient;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.hateoas.Resources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

@EnableZuulProxy
@SpringBootApplication
@EnableDiscoveryClient
public class RentClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(RentClientApplication.class, args);
	}

}

@RestController
@RequestMapping("/movies")
class RentsApiGateway {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping(method = RequestMethod.GET, value = "/all")
	public ResponseEntity movieNames() {
		ParameterizedTypeReference<List<String>> ptr = new ParameterizedTypeReference<List<String>>() {};

		ResponseEntity<List<String>> rsp = restTemplate.exchange("http://rent-service/allMovies",
				HttpMethod.GET,null, ptr);

		return rsp;
	}

	class MovieName {
		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
