package dotin.library_project.web;

import dotin.library_project.annotation.LogExecutionTime;
import dotin.library_project.data.entity.User;
import dotin.library_project.data.dto.UserDto;
import dotin.library_project.business.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @PreAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
    @GetMapping
    @Operation(summary = "return list of users")
    @LogExecutionTime
    public ResponseEntity<ApiResponse<?>> getUsersList(){
        List<User> users = service.getUsers();
        ApiResponse<?> response = new ApiResponse<>(true,users);
        return ResponseEntity.ok(response);
    }

    @PreAuthorize("hasRole('LIBRARIAN') or hasRole('ADMIN')")
    @PostMapping
    @Operation(summary = "add new user")
    public ResponseEntity<ApiResponse<?>> addNewUser(@Valid @RequestBody UserDto userdto){
        String result = service.addNewUser(userdto);
        ApiResponse<?> response = new ApiResponse<>(true, result);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}
