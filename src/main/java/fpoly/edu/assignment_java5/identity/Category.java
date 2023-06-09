package fpoly.edu.assignment_java5.identity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
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
@Table
public class Category {
	
	@Id
	private Long id;
	
	@Column(columnDefinition = "nvarchar(100)", nullable = false)
	private String name;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String description;
	
	@OneToMany(mappedBy = "category")	
	List<Book> book;
	
}
