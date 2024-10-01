package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.User;
import Dotin.LibraryProject.Repository.UserRepository;
import Dotin.LibraryProject.Service.UserService;
import Dotin.LibraryProject.Utils.UserCreateDTO;
import Dotin.LibraryProject.Utils.UserDTO;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping("users")
public class userController {
    @Autowired
    private UserService service;
    @Autowired
    private UserRepository userRepository;

    @GetMapping
    @Operation(summary = "return list of users")
    public List<UserDTO> getUsersList(){
        return service.getUsers();
    }

    @PostMapping
    @Operation(summary = "add new user")
    public ResponseEntity<String> addNewUser(@RequestBody UserCreateDTO user){
        boolean flag = service.addNewUser(user);
        if (flag){
            return ResponseEntity.ok("The User added successfully");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Password and Confirm Password do not match");
    }
}
