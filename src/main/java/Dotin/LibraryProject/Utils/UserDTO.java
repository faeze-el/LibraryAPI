package Dotin.LibraryProject.Utils;

import Dotin.LibraryProject.Entity.Enums.UserRole;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private Long id;
    private String name;
    private UserRole userRole;
}
