package dotin.library_project.web;

import dotin.library_project.annotation.LogExecutionTime;
import dotin.library_project.data.User;
import dotin.library_project.data.dto.UserDto;
import dotin.library_project.business.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

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
    public ResponseEntity<?> addNewUser(@Valid @RequestBody UserDto userdto){
        return service.addNewUser(userdto);
    }
}
