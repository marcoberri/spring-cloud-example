package it.marcoberri.microservice;

import java.util.concurrent.Future;

import org.springframework.data.repository.CrudRepository;
import org.springframework.scheduling.annotation.Async;

import it.marcoberri.microservice.model.Product;

public interface ProductRespository extends CrudRepository<Product, Long> {

	@Async
	Future<Product> findOneBySku(String sku);

}
