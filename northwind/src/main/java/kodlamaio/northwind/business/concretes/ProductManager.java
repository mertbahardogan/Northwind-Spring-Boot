package kodlamaio.northwind.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlamaio.northwind.business.abstracts.ProductService;
import kodlamaio.northwind.core.utilities.results.DataResult;
import kodlamaio.northwind.core.utilities.results.Result;
import kodlamaio.northwind.core.utilities.results.SuccessDataResult;
import kodlamaio.northwind.core.utilities.results.SuccessResult;
import kodlamaio.northwind.dataAccess.abstracts.ProductDao;
import kodlamaio.northwind.entities.concretes.Product;

@Service // Means business layer
public class ProductManager implements ProductService {

	// Dependency Injection
	private ProductDao productDao;

	@Autowired // Spring getter instance, bean means class.
	public ProductManager(ProductDao productDao) {
		super();
		this.productDao = productDao;
	}

	@Override
	// We could not subclasses for DataResult is super type.
	public DataResult<List<Product>> getAll() {
		// This is dependency anything. Therefore we can create with new.
		// We can say this is return of Entity.
		return new SuccessDataResult<List<Product>>(this.productDao.findAll(), "Data listed.");

		// this.productDao.findAll();
	}

	@Override
	public Result add(Product product) {
		this.productDao.save(product);
		return new SuccessResult("Product added.");
	}

}
