package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Book;

import java.util.List;

public interface BookRepository {

    public List<Book> getAllBooks();
    public void addBook(Book b);
    public Book getBookById(Long id);
    public Book getBookByTitle(String title);
    public boolean removeBookByTitle(String title);
}
