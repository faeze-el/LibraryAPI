package dotin.library_project.entity.dto;

import dotin.library_project.entity.Book;
import dotin.library_project.entity.User;
import dotin.library_project.entity.enums.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {
    @NotNull(message = "The userName is required.")
    @NotEmpty(message = "The userName can not be empty.")
    @Size(min=2, max=20, message = "The userName must be between 2 and 20 characters")
    private String userName;
    @NotNull(message = "The name is required.")
    @NotEmpty(message = "The name can not be empty.")
    @Size(min=2, max=20, message = "The name must be between 2 and 20 characters")
    private String name;
    @NotNull(message = "The password is required.")
    @NotEmpty(message = "The password can not be empty.")
    @Size(min=6, max=20, message = "The name must be between 6 and 20 characters")
    private String password;

    private String confirmPassword;

    public User toUser() {
        User u = new User();
        u.setUsername(userName);
        u.setName(name);
        u.setPassword(password);
        return u;
    }

}
