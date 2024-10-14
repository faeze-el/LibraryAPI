package dotin.library_project.data.dto;

import dotin.library_project.data.entity.User;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class UserDto {

    @NotBlank(message = "The userName is required and can not be empty.")
    @Size(min=2, max=20, message = "The userName must be between 2 and 20 characters")
    private String userName;

    @NotBlank(message = "The name is required and can not be empty.")
    @Size(min=2, max=20, message = "The name must be between 2 and 20 characters")
    private String name;

    @NotBlank(message = "The password is required and can not be empty.")
    @Size(min=6, max=20, message = "The name must be between 6 and 20 characters")
    private String password;


    public User toUser() {
        User u = new User();
        u.setUsername(userName);
        u.setName(name);
        u.setPassword(password);
        return u;
    }

}
