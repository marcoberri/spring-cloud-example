package it.marcoberri.configserver;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

@EnableConfigServer
@SpringBootApplication
public class ConfigServer {
	public static void main(String[] args) {
		SpringApplication.run(ConfigServer.class, args);
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