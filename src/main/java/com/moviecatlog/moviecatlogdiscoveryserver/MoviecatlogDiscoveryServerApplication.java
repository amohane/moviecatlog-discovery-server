package com.moviecatlog.moviecatlogdiscoveryserver;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableEurekaServer
@RestController
@RefreshScope
public class MoviecatlogDiscoveryServerApplication {
	@Value("${msg:Hi}")
	private String msg;
	@GetMapping("/hello")
	public String sayHi() {
		return msg;
	}

	public static void main(String[] args) {
		SpringApplication.run(MoviecatlogDiscoveryServerApplication.class, args);
	}

}
