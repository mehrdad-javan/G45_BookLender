package se.lexicon.g45_booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g45_booklender.entity.Author;

import java.util.List;

@Repository
public interface AuthorRepository extends CrudRepository<Author, Integer> {

    List<Author> findAllByWrittenBooksId(int bookId);
    //...

}
