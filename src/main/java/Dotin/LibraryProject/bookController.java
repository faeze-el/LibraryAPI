package Dotin.LibraryProject;

import Dotin.LibraryProject.Models.Book;
import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class bookController {
    LibraryCore libraryCore;
    public bookController(){
        libraryCore = LibraryCore.getInstance();
    }

    @GetMapping("/books")
    @Operation(summary = "return list of books")
    public String myTestGet(){

        List<Book> books = libraryCore.getBooks();
        return "There are " + books.size() + " books in this library:\n" + libraryCore.getBooks();
    }
    @PostMapping("/addbook")
    @Operation(summary = "add new book")
    public String myTestGet(@RequestParam String name, @RequestParam boolean isAvailable){
        return libraryCore.addBook(name, isAvailable);
    }
}
