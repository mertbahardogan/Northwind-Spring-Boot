package kodlamaio.northwind.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.entities.concretes.Product;
import kodlamaio.northwind.entities.dtos.ProductWithCategoryDto;

@RestController // Spring
@RequestMapping("/api/products/") // Meet request
public class ProductsController {

	private ProductService productService;

	@Autowired // scan project for productService, find in ProductManager
	// and generate instance then getter here
	public ProductsController(ProductService productService) {
		super();
		this.productService = productService;
	}

	@GetMapping("getAll")
	public DataResult<List<Product>> getAll() {
		return this.productService.getAll();
	}

	@PostMapping("add")
	// !We need body to add product.
	public Result add(@RequestBody Product product) {
		return this.productService.add(product);
	}

	@GetMapping("getByProductName")
	// Yapılan isteğin parametrelerine bak ordan oku, atamayı yap ve gönder.
	public DataResult<Product> getByProductName(@RequestParam String productName) {
		return this.productService.getByProductName(productName);
	}

	@GetMapping("getByProductNameAndCategoryId")
	public DataResult<Product> getByProductNameAndCategoryId(@RequestParam("productName") String productName,
			@RequestParam("categoryId") int categoryId) {
		return this.productService.getByProductNameAndCategoryId(productName, categoryId);
	}

	@GetMapping("getByProductNameOrCategoryId")
	public DataResult<List<Product>> getByProductNameOrCategoryId(@RequestParam String productName,
			@RequestParam int categoryId) {
		return this.productService.getByProductNameOrCategoryId(productName, categoryId);
	}

	@GetMapping("getByCategoryIdIn")
	public DataResult<List<Product>> getByCategoryIdIn(@RequestParam List<Integer> categories) {
		return this.productService.getByCategoryIdIn(categories);
	}

	@GetMapping("getByProductNameContains")
	public DataResult<List<Product>> getByProductNameContains(@RequestParam String productName) {
		return this.productService.getByProductNameContains(productName);
	}

	@GetMapping("getByProductNameStartsWith")
	public DataResult<List<Product>> getByProductNameStartsWith(@RequestParam String productName) {
		return this.productService.getByProductNameStartsWith(productName);
	}

	@GetMapping("getByNameAndCategory")
	public DataResult<List<Product>> getByNameAndCategory(@RequestParam String productName,
			@RequestParam int categoryId) {
		return this.productService.getByNameAndCategory(productName, categoryId);
	}

	@GetMapping("getAllByPage")
	public DataResult<List<Product>> getAll(int pageNo, int pageSize) {
		return this.productService.getAll(pageNo, pageSize);
	}

	@GetMapping("getAllDesc")
	public DataResult<List<Product>> getAllSorted() {
		return this.productService.getAllSorted();
	}

	@GetMapping("getProductWithCategoryDetails")
	public DataResult<List<ProductWithCategoryDto>> getProductWithCategoryDetails() {
		return this.productService.getProductWithCategoryDetails();
	}
}
