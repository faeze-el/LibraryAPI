package dotin.library_project.business.controller;

import dotin.library_project.business.LogExecutionTime;
import dotin.library_project.entity.Book;
import dotin.library_project.entity.User;
import dotin.library_project.entity.dto.UserDto;
import dotin.library_project.service.UserService;
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
    public ResponseEntity<String> addNewUser(@Valid @RequestBody UserDto userDto){
        if (userDto.getPassword().equals(userDto.getConfirmPassword())) {
            Optional<User> user = Optional.ofNullable(userDto.toUser());
            if (user.isPresent())
                return service.addNewUser(user.get());
        }
        return new ResponseEntity<>("Not valid inputs", HttpStatus.BAD_REQUEST);
    }
}
