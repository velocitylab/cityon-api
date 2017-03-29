package com.velo.cityon.api;

import java.io.IOException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.velo.cityon.api"})
@SpringBootApplication
public class Application {

	private static SpringApplication springApplication;
	private static ApplicationContext ctx;
	
	public static void main(String[] args) throws IOException {
		springApplication = new SpringApplication(Application.class);
		ctx = springApplication.run(args);
	}

	public static SpringApplication getSpringApplication() {
		return springApplication;
	}
	public static ApplicationContext getCtx() {
		return ctx;
	}
}
