package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.Book;
import Dotin.LibraryProject.Service.BookService;
import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {
    @Autowired
    private BookService service;
//    LibraryCore libraryCore;
//    public bookController(){
//        libraryCore = LibraryCore.getInstance();
//    }

    @GetMapping("/books")
    @Operation(summary = "return list of books")
    public List<Book> getBooksList(){
        return service.getBooks();
    }

//    @PostMapping("/add")
//    @Operation(summary = "add new book")
//    public String addNewBook(@RequestParam String name, @RequestParam boolean isAvailable){
//        return libraryCore.addBook(name, isAvailable);
//    }
//
//    @DeleteMapping("/books/{title}")
//    @Operation(summary = "remove a book")
//     public String removeBook(@PathVariable String title) {
//        return libraryCore.removeBookByTitle(title);
//    }
}
