package fpoly.edu.assignment_java5.service.book;

import java.util.List;

import fpoly.edu.assignment_java5.identity.Book;

public interface BookService {
	
	public List<Book> getAllBooks();
	
	public List<Book> getBookListByCategory();
	
	public List<Book> getBookListByKeyword();
	
	public void insertBook(Book paramBook);
	
	public void deleteBook(Book paramBook);
	
	public void updateBook(Book paramBook);
	
	public List<Book> priceDescPriceBookList();
	
	public List<Book> getBestSellerBooks();

	Book getBookById(Long id);
	
}
