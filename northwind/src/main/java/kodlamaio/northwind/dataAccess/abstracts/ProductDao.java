package kodlamaio.northwind.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;
import kodlamaio.northwind.entities.concretes.Product;

//Interface extends interface
//JpaRepository=BaseRepository
//We say supposed to ready which table and id type to repository
//Integer = PK
public interface ProductDao extends JpaRepository<Product, Integer>{
	
}