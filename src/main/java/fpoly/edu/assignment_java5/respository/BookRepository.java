package fpoly.edu.assignment_java5.respository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import fpoly.edu.assignment_java5.identity.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
	
	List<Book> findAll();
	
	@Query("SELECT b FROM Book u WHERE u.name LIKE CONCAT('%', :keyword, '%')")
	List<Book> getBookListByKeyword(@Param("keyword") String keyword);
	
	
	
}
