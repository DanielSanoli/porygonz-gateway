package br.com.porygonz.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PorygonzApplication {

	public static void main(String[] args) {
		SpringApplication.run(PorygonzApplication.class, args);
	}

}
