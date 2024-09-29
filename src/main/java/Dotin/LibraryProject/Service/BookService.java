package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;


    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookRepository.getAllBooks();
        if(books!=null && !books.isEmpty())
            return  new ResponseEntity<List<Book>>(books, HttpStatus.OK);
        return new ResponseEntity<List<Book>>(new ArrayList<>(), HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<String> addNewBook(Book b) {
        bookRepository.addBook(b);
        return new ResponseEntity<String>("Book added successfully", HttpStatus.CREATED);
    }
    public ResponseEntity<Book> getBookById(Long id) {
        final Book result =  bookRepository.getBookById(id);
        return new ResponseEntity<>(result, Objects.nonNull(result) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<String> removeBookByTitle(String title) {
        boolean flag =  bookRepository.removeBookByTitle(title);
        if(flag)
            return new ResponseEntity<>( "Book removed", HttpStatus.OK );
        return new ResponseEntity<>( "Can not find the book", HttpStatus.NOT_FOUND);
    }
}
