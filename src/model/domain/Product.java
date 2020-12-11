package model.domain;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

@ToString(exclude="orders")
@Builder

@Entity
@SequenceGenerator(name="product_id_seq_gen", sequenceName="product_id_seq", initialValue=1, allocationSize=50)
public class Product {
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="product_id_seq_gen")
	@Column(name="pno", precision=20)
	private int productNo;
	
	@Column(name="pname", nullable=false, length=40)
	private String productName;
	
	@Column(name="price", nullable=false)
	private int price;
	
	@OneToMany(mappedBy="productNumber")
	private List<Orders> orders;
}
