package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> getAllBooks();
    public void addBook(String title);
    public Book getBookById(Long id);
}
