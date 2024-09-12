package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Service.BookService;
import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
@RequestMapping("/books")
public class bookController {
    @Autowired
    private BookService service;
//    LibraryCore libraryCore;
//    public bookController(){
//        libraryCore = LibraryCore.getInstance();
//    }

    @GetMapping
    @Operation(summary = "return list of books")
    public List<Book> getBooksList(){
        return service.getBooks();
    }

    @GetMapping("{id}")
    @Operation(summary = "return a book by id given or null if not found")
    public ResponseEntity<Book> getBookByID(@RequestParam Long id){
        Book res = service.getBookById(id);
        return new ResponseEntity<>(res, Objects.nonNull(res) ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PostMapping
    @Operation(summary = "add new book")
    public String addNewBook(@RequestParam String name){
        service.addNewBook(name);
        return "success";
    }
//
//    @DeleteMapping("/books/{title}")
//    @Operation(summary = "remove a book")
//     public String removeBook(@PathVariable String title) {
//        return libraryCore.removeBookByTitle(title);
//    }
}
