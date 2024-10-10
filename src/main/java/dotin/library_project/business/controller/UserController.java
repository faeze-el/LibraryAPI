package dotin.library_project.business.controller;

import dotin.library_project.business.LogExecutionTime;
import dotin.library_project.entity.User;
import dotin.library_project.service.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "return list of users")
    @LogExecutionTime
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
