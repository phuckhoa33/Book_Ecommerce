package fpoly.edu.assignment_java5.controller.book;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.service.book.BookService;
import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/book")
public class BookSpaceController {
	
	@Autowired
	BookService bookService;
	
	@Autowired
	HttpServletRequest request;
	
	@GetMapping("/view")
	public String showBookList() {
		
		List<Book> result = bookService.priceDescPriceBookList();
		
		request.setAttribute("result", result);
				
		return "/book/showBookTest";
	}
	
	
	
}
