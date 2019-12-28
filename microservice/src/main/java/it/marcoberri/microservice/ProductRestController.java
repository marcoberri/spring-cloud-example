package it.marcoberri.microservice;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.netflix.discovery.shared.Application;

import it.marcoberri.microservice.model.Product;

@org.springframework.web.bind.annotation.RestController
public class ProductRestController {

	@Autowired
	private EurekaClient eurekaClient;

	@Value("${service.ms.serviceId}")
	private String msServiceId;

	@Autowired
	private RestTemplate restTemplate;

	@Autowired
	private ProductRespository productRepository;

	/**
	 * Find by sku 
	 * @param sku
	 * @return {@code Product}
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	@GetMapping(value = "/product/{sku}", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product getProductBySku(@PathVariable("sku") String sku) throws InterruptedException, ExecutionException {
		return productRepository.findOneBySku(sku);
	}

	/**
	 * Save data
	 * 
	 * @param product
	 * @return {@code Product}
	 */
	@PostMapping(value = "/product/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Product saveProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}

	/**
	 * Call another service passing from eureka instance
	 * 
	 * @return
	 */
	@GetMapping(value = "/products/", produces = MediaType.APPLICATION_JSON_VALUE)
	public Collection<Product> getAllProduct() {

		Application application = eurekaClient.getApplication(msServiceId);
		InstanceInfo instanceInfo = application.getInstances().get(0);
		String url = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/product/200";
		System.out.println("URL: " + url);
		Product prod = restTemplate.getForObject(url, Product.class);

		String url2 = "http://" + instanceInfo.getIPAddr() + ":" + instanceInfo.getPort() + "/product/2002";
		System.out.println("URL: " + url2);
		Product prod2 = restTemplate.getForObject(url2, Product.class);

		ArrayList<Product> l = new ArrayList<Product>();
		l.add(prod);
		l.add(prod2);
		return l;

	}

}
