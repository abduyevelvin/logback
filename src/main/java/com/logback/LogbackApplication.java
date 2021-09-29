package com.logback;

import ch.qos.logback.classic.Logger;
import com.logback.config.LoggerUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LogbackApplication {

	public static void main(String[] args) {
		SpringApplication.run(LogbackApplication.class, args);
		LoggerUtils.createLoggerFor();
	}

}
