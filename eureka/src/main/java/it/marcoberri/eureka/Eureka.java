package it.marcoberri.eureka;

import java.util.Date;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.trace.http.HttpTraceRepository;
import org.springframework.boot.actuate.trace.http.InMemoryHttpTraceRepository;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.event.ApplicationFailedEvent;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.event.ContextClosedEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableEurekaServer
public class Eureka {
	public static void main(String[] args) {
		SpringApplication.run(Eureka.class, args);
	}

	@ConditionalOnMissingBean
	@Bean
	public HttpTraceRepository httpTraceRepository() {
		return new InMemoryHttpTraceRepository();
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