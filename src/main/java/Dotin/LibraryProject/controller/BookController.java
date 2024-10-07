package Dotin.LibraryProject.controller;

import Dotin.LibraryProject.entity.Book;
import Dotin.LibraryProject.service.BookService;
import io.swagger.v3.oas.annotations.Operation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    public ResponseEntity<String> addNewBook(@RequestBody Book book){
        return  service.addNewBook(book);
    }

    @DeleteMapping("{title}")
    @Operation(summary = "remove a book by title")
     public ResponseEntity<String> removeBook(@PathVariable String title) {
        return service.removeBookByTitle(title);
    }
}
