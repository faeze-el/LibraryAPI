package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.User;
import Dotin.LibraryProject.Service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class userController {
    @Autowired
    private UserService service;

    @GetMapping
    @Operation(summary = "return list of users")
    public List<User> getUsersList(){
        return service.getUsers();
    }

    @PostMapping
    @Operation(summary = "add new user")
    public ResponseEntity<String> addNewUser(@RequestBody User user){
        service.addNewUser(user);
        return new ResponseEntity<>("The User added successfully", HttpStatus.CREATED);
    }
}
