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
        return bookRepository.findAll();
    }
    public void addNewBook(Book b) {
        bookRepository.save(b);
    }
    public Book getBookById(Long id) {
        return bookRepository.findById(id).orElse(null);
    }
    @Transactional
    public Long removeBookByTitle(String title) {
        return bookRepository.deleteBookByTitle(title);
    }
}
