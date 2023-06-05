package fpoly.edu.assignment_java5.identity;

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
public class CartItem {
	private int bookId;
	private String bookName;
	private double bookPrice;
	private int qty = 1;
		
}
