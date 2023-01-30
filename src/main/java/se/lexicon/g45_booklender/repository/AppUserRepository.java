package se.lexicon.g45_booklender.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import se.lexicon.g45_booklender.entity.AppUser;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Repository
public interface AppUserRepository extends CrudRepository<AppUser, Integer> {

    // select * from app_user where username = 1?
    Optional<AppUser> findByUsername(String username);
    @Query("select a from AppUser a where a.username = :un")
    Optional<AppUser> selectByUsername(@Param("un") String username);


    List<AppUser> findAllByRegDateBetween(LocalDate from, LocalDate to);
    @Query("select a from AppUser a where a.regDate >= :from and a.regDate <= :to") //
    List<AppUser> selectByRegistrationDate(@Param("from") LocalDate from, @Param("to") LocalDate to);



    @Modifying
    @Query("update AppUser a set a.password = :pwd where a.username = :un")
    void resetPassword(@Param("un") String username, @Param("pwd") String password);
}
