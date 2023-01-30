package se.lexicon.g45_booklender.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import se.lexicon.g45_booklender.exception.DataDuplicateException;
import se.lexicon.g45_booklender.exception.DataNotFoundException;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Data

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String isbn;
    private String title;
    private int maxLoanDays;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "book_id"),
            inverseJoinColumns = @JoinColumn(name = "author_id")
    )
    private List<Author> authors = new ArrayList<>();


    public Book(String isbn, String title, int maxLoanDays) {
        this.isbn = isbn;
        this.title = title;
        this.maxLoanDays = maxLoanDays;
    }


    public void addAuthor(Author author){
        if (authors.contains(author)){
            throw new DataDuplicateException("DataDuplicateException");
        }
        authors.add(author);
    }


    public void removeAuthor(Author author){
        if (!authors.contains(author)){
            throw new DataNotFoundException("DataNotFoundException");
        }
        authors.remove(author);
    }
}
