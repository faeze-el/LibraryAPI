package dotin.library_project.repository;

import dotin.library_project.data.Book;
import dotin.library_project.data.enums.BookStatus;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BookRepository {

    public List<Book> getAllBooks();
    public void addBook(Book b);
    public Book getBookById(Long id);
    public Book getBookByTitle(String title);
    public boolean removeBookByTitle(String title);
    public void updateStatusById(Long id , BookStatus status);
}