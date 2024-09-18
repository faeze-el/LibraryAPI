package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Repository.BookRepositoryByDb;
import Dotin.LibraryProject.Repository.BookRepositoryNoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepositoryNoDb bookRepository;
    @Autowired
    private BookRepositoryByDb bookRepositoryByDb;

    public List<Book> getBooks() {
//        return bookRepository.getAllBooks();
        return bookRepositoryByDb.getAllBooks();
    }
    public void addNewBook(Book b) {
//        bookRepository.addBook(b);
        bookRepositoryByDb.addBook(b);
    }
    public Book getBookById(Long id) {
//        return bookRepository.getBookById(id);
        return bookRepositoryByDb.getBookById(id);
    }
    public boolean removeBookByTitle(String title) {
//        return bookRepository.removeBookByTitle(title);
        return bookRepositoryByDb.removeBookByTitle(title);
    }
}
