package dotin.library_project.web;

import dotin.library_project.data.Book;
import dotin.library_project.data.dto.BookDto;
import dotin.library_project.business.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private static final Logger logger = LoggerFactory.getLogger(BookController.class);

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "return list of books")
    public ResponseEntity<List<Book>> getBooksList(){
        return service.getBooks();
    }

    @GetMapping("{id}")
    @Operation(summary = "return a book by id given or null if not found")
    public ResponseEntity<Book> getBookByID(@PathVariable Long id){
        return service.getBookById(id);
    }

    @PostMapping
    @Operation(summary = "add new book")
    public ResponseEntity<?> addNewBook(@Valid @RequestBody BookDto bookdto)
    {
        return service.addNewBook(bookdto);
    }

    @DeleteMapping("{title}")
    @Operation(summary = "remove a book by title")
     public ResponseEntity<String> removeBook(@PathVariable String title) {

        return service.removeBookByTitle(title);
    }
}
