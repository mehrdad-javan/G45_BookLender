package se.lexicon.g45_booklender.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@NoArgsConstructor
@AllArgsConstructor
@Data // ToString, EqualAndHashCode, Getter & Setter + RequireArgsConstructor.

@Entity
public class Details {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(unique = true, nullable = false)
    private String email;
    @Column(nullable = false)
    private String name;
    private LocalDate birthDate;

    public Details(String email, String name, LocalDate birthDate) {
        this.email = email;
        this.name = name;
        this.birthDate = birthDate;
    }
}
