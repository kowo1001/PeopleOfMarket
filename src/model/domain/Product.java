package model.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
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
	
	
}
