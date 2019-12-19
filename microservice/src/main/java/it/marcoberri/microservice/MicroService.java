package it.marcoberri.microservice;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableDiscoveryClient
public class MicroService {
	public static void main(String[] args) {
		SpringApplication.run(MicroService.class, args);
	}

	@Bean
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

	
	/**
	 * Evento di ready
	 */
	@EventListener(ApplicationReadyEvent.class)
	public void EventListenerExecute() {
		System.out.println("Application Ready Event is successfully Started at " + new Date() + "!");
	}

	/**
	 * Evento di esecuzione andata a male
	 */
	@EventListener(ApplicationFailedEvent.class)
	public void EventListenerExecuteFailed() {
		System.out.println("Application Event Listener is Failed at " + new Date() + "!");
	}

	/**
	 * Evento di stop applicativo
	 */
	@EventListener(ContextClosedEvent.class)
	public void ContextClosedEvent() {
		System.out.println("Application Context is Closed at " + new Date() + "!");
	}
	
}