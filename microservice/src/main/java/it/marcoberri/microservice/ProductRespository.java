package it.marcoberri.microservice;

import org.springframework.data.repository.CrudRepository;

import it.marcoberri.microservice.model.Product;

public interface ProductRespository extends CrudRepository<Product, Long> {

	
	Product findOneBySku(String sku);

}
