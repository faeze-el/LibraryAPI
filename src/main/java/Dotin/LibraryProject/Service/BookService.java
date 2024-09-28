package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }
    public void addNewBook(Book b) {
        bookRepository.addBook(b);
    }
    public Book getBookById(Long id) {
        return bookRepository.getBookById(id);
    }
    @Transactional
    public boolean removeBookByTitle(String title) {
        return bookRepository.removeBookByTitle(title);
    }
}
