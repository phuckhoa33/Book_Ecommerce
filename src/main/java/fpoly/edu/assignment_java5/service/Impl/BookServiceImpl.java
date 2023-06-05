package fpoly.edu.assignment_java5.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fpoly.edu.assignment_java5.identity.Book;
import fpoly.edu.assignment_java5.respository.BookRepository;
import fpoly.edu.assignment_java5.service.book.BookService;

@Service
public class BookServiceImpl implements BookService{

	@Autowired
	BookRepository bookRepository;
	
	@Override
	public List<Book> getAllBooks() {
		
		List<Book> result = bookRepository.findAll();
		
		return result;
	}

	@Override
	public List<Book> getBookListByCategory() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getBookListByKeyword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void insertBook(Book paramBook) {
		bookRepository.save(paramBook);
		
	}

	@Override
	public void deleteBook(Book paramBook) {
		bookRepository.delete(paramBook);
		
	}

	@Override
	public void updateBook(Book paramBook) {
		
		
	}

	@Override
	public List<Book> priceDescPriceBookList() {
		
		List<Book> result = bookRepository.priceDescPriceBookList();
		
		return result;
	}

	@Override
	public List<Book> getBestSellerBooks() {
		
		List<Book> result = bookRepository.getBestSellerBooks();
		
		return result;
	}
	
	@Override
	public Book getBookById(Long id) {
		
		Book result =  new Book();
		
		result = bookRepository.getBookById(id);
		
		
		return result;
	}
	
	

	
	
}
