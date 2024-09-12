package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class BookRepositoryNoDb  implements   BookRepository{
    private List<Book> list = new ArrayList<>(Arrays.asList(
            new Book(1L, "book1", true),
            new Book(2L, "book2", true),
            new Book(3L, "book3", true)
    ));

    public List<Book> getAllBooks() {
        return list;
    }

    public void addBook(String title) {
        Book b = new Book((long) list.size()+1, title, true);
        list.add(b);
    }
}
