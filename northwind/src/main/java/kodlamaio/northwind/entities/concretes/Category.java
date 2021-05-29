package kodlamaio.northwind.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "categories")
@Entity
//sonsuz döngüye girmeyi engeller.
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "products" })
public class Category {

	@Id
	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "category_name")
	private String categoryName;

	// Categorinin sahip olduğu ürünler //FK var.
	// Ana tablo burası o yüzden burda yapıyoruz.
	@OneToMany(mappedBy = "category") // product tablosundaki category alanı ile ilişkilendirildi.
	private List<Product> products; // Tablo gibi düşün.
}