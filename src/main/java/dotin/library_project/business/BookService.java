package dotin.library_project.business;

import dotin.library_project.data.converter.BookConverter;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.dto.BookDto;
import dotin.library_project.repository.BookRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BookService {

    private final BookRepository bookRepository;


    public BookService(@Qualifier("bookRepositoryByDb") BookRepository bookRepository ) {
        this.bookRepository = bookRepository;
    }

    public ResponseEntity<List<Book>> getBooks() {
        List<Book> books = bookRepository.getAllBooks();
        if(books!=null && !books.isEmpty())
            return new ResponseEntity<>(books, HttpStatus.OK);
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NO_CONTENT);
    }
    public ResponseEntity<?> addNewBook(BookDto bookdto) {
        try {
            Optional<Book> book = BookConverter.convertToBook(bookdto);
            if(book.isPresent()) {
                bookRepository.addBook(book.get());
                return new ResponseEntity<>("Book added successfully", HttpStatus.CREATED);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>("Not valid inputs", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<?> getBookById(Long id) {
        if (id<=0) return new ResponseEntity<>("Enter a positive Id.",HttpStatus.BAD_REQUEST);
        final Optional<Book> result = Optional.ofNullable(bookRepository.getBookById(id));
        if (result.isPresent())
            return new ResponseEntity<>(result.get(), HttpStatus.OK);
        else return new ResponseEntity<>("Book not found", HttpStatus.NOT_FOUND);
    }
    @Transactional
    public ResponseEntity<String> removeBookByTitle( String title) {
        if (Objects.isNull(title) || title.isEmpty()) return new ResponseEntity<>("Enter a valid title.",HttpStatus.BAD_REQUEST);
        boolean flag =  bookRepository.removeBookByTitle(title);
        if(flag)
            return new ResponseEntity<>( "Book removed", HttpStatus.OK );
        return new ResponseEntity<>( "Can not find the book", HttpStatus.NOT_FOUND);
    }
}
