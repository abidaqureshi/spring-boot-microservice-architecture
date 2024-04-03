package com.rakuten.hotelservices;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class HotelservicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelservicesApplication.class, args);
	}

}
