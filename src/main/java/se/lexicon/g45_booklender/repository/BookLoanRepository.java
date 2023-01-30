package se.lexicon.g45_booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g45_booklender.entity.BookLoan;

@Repository
public interface BookLoanRepository extends CrudRepository<BookLoan, Integer> {

}
