package it.marcoberri.microservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

@org.springframework.web.bind.annotation.RestController
public class ConfigRestController {

	@Value("${application.name}")
	private String applicationName;

	@Value("${application.author}")
	private String applicationauthor;

	@GetMapping(value = "/config/application/name", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getApplicationName() {
		return applicationName;
	}

	@GetMapping(value = "/config/application/author", produces = MediaType.TEXT_PLAIN_VALUE)
	public String getApplicationAuthor() {
		return applicationauthor;
	}
}
