package Dotin.LibraryProject.repository;

import Dotin.LibraryProject.entity.Book;
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