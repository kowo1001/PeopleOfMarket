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

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString(exclude="orders")
@Builder

@Entity
@SequenceGenerator(name="mart_id_seq_gen", sequenceName="mart_id_seq", initialValue=1, allocationSize=50)
public class Mart {
	
	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="mart_id_seq_gen")
	@Column(name="mtno", precision=10)
	private int martNumber;
	
	@Column(name="mtname", nullable=false, length=40)
	private String martName;
	
	@Column(name="loc", nullable=false, length=40)
	private String location;
<<<<<<< HEAD

=======
	
	@OneToMany(mappedBy="martNumber")
	private List<Orders> orders;
>>>>>>> a2e887067f04e4f54aa28bc829d4be0e4ff338a4
}
