package fpoly.edu.assignment_java5.identity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "Orderdetail")
public class OrderDetail {
		
	@Id
	private Long id;
	
	private Double price;
	
	Integer quantity;
	
	@ManyToOne
	@JoinColumn(name = "BookId")
	Book book;
	
	@ManyToOne
	@JoinColumn(name = "OrderId")
	OrderItem orderItem;
}
