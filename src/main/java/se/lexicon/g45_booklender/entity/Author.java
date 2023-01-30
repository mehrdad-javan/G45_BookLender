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
public class Author {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToMany(cascade = {CascadeType.DETACH, CascadeType.REFRESH, CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "books_authors",
            joinColumns = @JoinColumn(name = "author_id"),
            inverseJoinColumns = @JoinColumn(name = "book_id")
    )
    private List<Book> writtenBooks = new ArrayList<>();


    public void addBook(Book book) {
        if (writtenBooks.contains(book)) {
            throw new DataDuplicateException("DataDuplicateException");
        }
        writtenBooks.add(book);
    }


    public void removeBook(Book book) {
        if (!writtenBooks.contains(book)) {
            throw new DataNotFoundException("DataNotFoundException");
        }
        writtenBooks.remove(book);
    }

}
