package se.lexicon.g45_booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g45_booklender.entity.Book;

import java.util.List;

@Repository
public interface BookRepository extends CrudRepository<Book, Integer> {

    List<Book> findAllByIsbn(String isbn);

    List<Book> findAllByTitleContains(String title);

    List<Book> findAllByTitleContainsIgnoreCase(String title);

}
