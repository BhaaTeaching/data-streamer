package com.shekel.data_streamer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.util.logging.Logger;

@SpringBootApplication
@EnableScheduling
public class DataStreamerApplication {

	public static void main(String[] args) {
		SpringApplication.run(DataStreamerApplication.class, args);
		Logger.getLogger(DataStreamerApplication.class.getName()).info("Data Streamer started :)");
	}

}
