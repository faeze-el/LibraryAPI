package dotin.library_project.web;

import dotin.library_project.data.entity.Book;
import dotin.library_project.data.dto.BookDto;
import dotin.library_project.business.BookService;
import dotin.library_project.exception_handler.MyException;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
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
    public ResponseEntity<ApiResponse<?>> getBooksList() throws MyException {
        ApiResponse<?> response = service.getBooks();
        return ResponseEntity.ok(response);
    }

    @GetMapping("{id}")
    @Operation(summary = "return a book by id given or null if not found")
    public ResponseEntity<ApiResponse<?>> getBookByID(@Valid @PathVariable  Long id) throws Exception {
        ApiResponse<?> response = service.getBookById(id);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "add new book")
    public ResponseEntity<ApiResponse<?>> addNewBook(@Valid @RequestBody BookDto bookdto) throws Exception
    {
        ApiResponse<?> response = service.addNewBook(bookdto);
        return new ResponseEntity<>(response,HttpStatus.CREATED);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @DeleteMapping("{title}")
    @Operation(summary = "remove a book by title")
     public ResponseEntity<ApiResponse<?>> removeBook(@Valid @PathVariable String title) throws MyException {
        ApiResponse<?> response = service.removeBookByTitle(title);
        return ResponseEntity.ok(response);
    }
}
