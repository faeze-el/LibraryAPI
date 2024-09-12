package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Repository.BookRepositoryNoDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepositoryNoDb bookRepository;

    public List<Book> getBooks() {
        return bookRepository.getAllBooks();
    }
    public void addNewBook(String title) { bookRepository.addBook(title);}
}
