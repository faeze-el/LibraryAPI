package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepositoryNoDb  implements   BookRepository{
    private List<Book> list = new ArrayList<>(Arrays.asList(
            new Book(1L, "product 1", true),
            new Book(2L, "product 2", true),
            new Book(3L, "product 3", true)
    ));

    public List<Book> getAllBooks() {
        return list;
    }
}
