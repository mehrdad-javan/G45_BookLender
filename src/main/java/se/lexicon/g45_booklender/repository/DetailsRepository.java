package se.lexicon.g45_booklender.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import se.lexicon.g45_booklender.entity.Details;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface DetailsRepository extends CrudRepository<Details, Integer> {

    Optional<Details> findByEmailIgnoreCase(String email);

    List<Details> findAllByNameContains(String name);

    List<Details> findAllByNameIgnoreCaseAndBirthDate(String name, LocalDate birthDate);

}
