package Dotin.LibraryProject.Api;

import Dotin.LibraryProject.Models.Book;
import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class bookController {
    LibraryCore libraryCore;
    public bookController(){
        libraryCore = LibraryCore.getInstance();
    }

    @GetMapping("/bookslist")
    @Operation(summary = "return list of books")
    public String getBooksList(){
        List<Book> books = libraryCore.getBooks();
        return "There are " + books.size() + " books in this library:\n" + books;
    }

    @PostMapping("/add")
    @Operation(summary = "add new book")
    public String addNewBook(@RequestParam String name, @RequestParam boolean isAvailable){
        return libraryCore.addBook(name, isAvailable);
    }

    @DeleteMapping("/books/{title}")
    @Operation(summary = "remove a book")
     public String removeBook(@PathVariable String title) {
        return libraryCore.removeBookByTitle(title);
    }
}
