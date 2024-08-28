package Dotin.LibraryProject;

import Dotin.LibraryProject.Models.Book;
import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.atomic.LongAdder;

@RestController
public class bookController {
    LibraryCore libraryCore;
    public bookController(){
        libraryCore = LibraryCore.getInstance();
    }

    @GetMapping("/bookslist")
    @Operation(summary = "return list of books")
    public String myTestGet(){

        List<Book> books = libraryCore.getBooks();
        return "There are " + books.size() + " books in this library:\n" + libraryCore.getBooks();
    }

    @PostMapping("/add")
    @Operation(summary = "add new book")
    public String myTestGet(@RequestParam String name, @RequestParam boolean isAvailable){
        return libraryCore.addBook(name, isAvailable);
    }

    @DeleteMapping("/books/{title}")
    @Operation(summary = "remove a book")
     public String deleteEmployee(@PathVariable String title) {
        return libraryCore.removeBookByTitle(title);
    }
}
