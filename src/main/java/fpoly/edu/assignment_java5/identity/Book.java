package fpoly.edu.assignment_java5.identity;

import jakarta.persistence.Column;
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
@Table(name = "Book")
public class Book {
	
	@Id
	@Column(name = "book_id")
	private Long id;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String name;
	
	private Long price;
	
	private Long discount;
	
	@Column(columnDefinition = "nvarchar(200)")
	private String description;
	
	@Column(columnDefinition = "nvarchar(100)")
	private String authorName;
	
	@Column(columnDefinition = "nvarchar(500)")
	private String image;
	
	@ManyToOne
	@JoinColumn(name = "categoryId")
	Category category;
	
	
	
}
