package com.launchpad.idea_backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {
		"com.launchpad.idea_backend"
})
public class IdeaBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(IdeaBackendApplication.class, args);
	}

}
