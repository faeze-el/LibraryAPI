package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public void addBook(Book b) {
        Book book = new Book((long) list.size()+1, b.getTitle(), b.isAvailable());
        list.add(book);
    }
    public Book getBookById(Long id){
        for(Book b : list){
            if (b.getBookId() == id) return b;
        }
        return null;
    }
    public Book getBookByTitle(String title){
        for(Book b : list){
            if (Objects.equals(b.getTitle(), title)) return b;
        }
        return null;
    }
    public boolean removeBookByTitle(String title){
        Book b = getBookByTitle(title);
        if(Objects.nonNull(b)){
            list.remove(b);
            return true;
        }
        return false;
    }
}
