package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    public List<Book> getAllBooks();
    public void addBook(Book b);
    public Book getBookById(Long id);
    public Book getBookByTitle(String title);
    public boolean removeBookByTitle(String title);
}