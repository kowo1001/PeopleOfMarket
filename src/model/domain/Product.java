package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
<<<<<<< HEAD
@ToString
=======
@ToString(exclude="orders")
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
@Builder

@Entity
public class Product {
	@Id
	
	@Column(name="pno", precision=20, nullable=false)
	private int productNo;
	
	@Column(name="pname", nullable=false, length=40)
	private String productName;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@OneToMany(mappedBy="productNumber")
	private List<Orders> orders;
}
