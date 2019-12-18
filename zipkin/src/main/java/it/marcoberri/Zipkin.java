package it.marcoberri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import zipkin2.server.internal.EnableZipkinServer;

@SpringBootApplication
@EnableZipkinServer
public class Zipkin {
	public static void main(String[] args) {
		SpringApplication.run(Zipkin.class, args);
	}
}