package com.beamchallenge.server.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.beamchallenge"})
public class HotelReservationsApplication {

	public static void main(String[] args) {
		SpringApplication.run(HotelReservationsApplication.class, args);
	}
}
