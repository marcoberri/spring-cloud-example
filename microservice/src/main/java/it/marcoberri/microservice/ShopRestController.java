package it.marcoberri.microservice;

import javax.websocket.server.PathParam;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;

import it.marcoberri.microservice.model.Product;

@org.springframework.web.bind.annotation.RestController
public class ShopRestController {

	@GetMapping(value = "/product/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductBySku(@PathParam("sku") String sku) {
		Product product = new Product();
		product.setSku(sku);
		product.setName("Sample Name");
		product.setPrice(10.45);
		return product;
	}
}
