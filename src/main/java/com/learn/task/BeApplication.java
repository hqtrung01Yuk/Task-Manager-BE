package com.learn.task;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import com.learn.task.services.jwt.JwtProperties;
import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication(scanBasePackages = {"com.learn.task", "com.learn.bootstrap"})
@EnableConfigurationProperties(JwtProperties.class)
public class BeApplication {

	public static void main(String[] args) {
		// Load .env variables
		Dotenv dotenv = Dotenv.configure().directory("BE").filename(".env").load();
		dotenv.entries().forEach(entry -> System.setProperty(entry.getKey(), entry.getValue()));

		SpringApplication.run(BeApplication.class, args);
	}

}
