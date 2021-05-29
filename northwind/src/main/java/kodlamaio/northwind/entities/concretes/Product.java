package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations
@Entity // Use JPA infrastructure, Means Database Object
@Table(name = "products") // Database ..
@Data 
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id // For info
	@GeneratedValue(strategy = GenerationType.IDENTITY) // How to produce
	@Column(name = "product_id") // Database..
	private int id;

	//Altta joinlediğimiz için iptal ettik. Category içinde zaten var çünkü.
	//@Column(name = "category_id")
	//private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

	// Her productın bir categorysi olduğu için list demedik.
	// Category her sütunu burda var sayılır.
	@ManyToOne()
	@JoinColumn(name = "category_id")
	private Category category; 

}
