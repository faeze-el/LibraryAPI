package Dotin.LibraryProject;

import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class oneController {
    @GetMapping("/myTest")
    @Operation(summary = "myTest")
    public String myTestGet(@RequestParam String name){
        LibraryCore libraryCore = LibraryCore.getInstance();
        return "Number of books " + name + "!" + libraryCore.getBooks();
    }
}
