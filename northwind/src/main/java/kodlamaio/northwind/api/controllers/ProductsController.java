package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.entities.concretes.Product;

@RestController // Spring
@RequestMapping("/api/products") // Meet request
public class ProductsController {

	private ProductService productService;

	@Autowired //scan project for productService, find in ProductManager 
	//and generate instance then getter here 
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("/getall")
	public List<Product> getAll() {
		return this.productService.getAll();
	}
}
