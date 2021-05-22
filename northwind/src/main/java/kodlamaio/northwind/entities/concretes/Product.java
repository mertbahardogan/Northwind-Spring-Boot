package kodlamaio.northwind.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

//Annotations
@Entity // Use JPA infrastructure, Means Database Object
@Table(name = "products") // Database ..
@Data // convert to Lombok
@AllArgsConstructor
@NoArgsConstructor
public class Product {

	@Id // For info
	@GeneratedValue(strategy = GenerationType.IDENTITY) // How to produce
	@Column(name = "product_id") // Database..
	private int id;

	@Column(name = "category_id")
	private int categoryId;

	@Column(name = "product_name")
	private String productName;

	@Column(name = "unit_price")
	private double unitPrice;

	@Column(name = "units_in_stock")
	private short unitsInStock;

	@Column(name = "quantity_per_unit")
	private String quantityPerUnit;

}
