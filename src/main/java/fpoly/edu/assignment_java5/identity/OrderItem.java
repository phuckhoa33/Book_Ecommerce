package fpoly.edu.assignment_java5.identity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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
@Table(name = "Orders")
public class OrderItem {
	
	private Long id;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String address;
	
	private Long quantity;
	
	private Date createdDate;
	
	@ManyToOne
	@JoinColumn(name = "id")
	private User user;
	
	
}
