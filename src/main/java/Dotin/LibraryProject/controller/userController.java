package Dotin.LibraryProject.controller;

import Dotin.LibraryProject.entity.User;
import Dotin.LibraryProject.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class userController {
    private final UserService service;

    public userController(UserService service) {
        this.service = service;
    }

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
