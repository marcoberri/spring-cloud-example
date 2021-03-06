package it.marcoberri;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

import de.codecentric.boot.admin.server.config.EnableAdminServer;

@Configuration
@EnableAutoConfiguration
@EnableAdminServer
public class Admin {
	public static void main(String[] args) {
		SpringApplication.run(Admin.class, args);
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