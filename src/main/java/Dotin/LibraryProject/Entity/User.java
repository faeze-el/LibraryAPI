package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Entity.Enums.UserRole;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public @Data class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    @Getter(AccessLevel.NONE)
    String password;
    @Enumerated(EnumType.STRING)
    UserRole role;
    @Override
    public String toString() {
        return "User{" +
                ", ID='" + this.id + '\'' +
                ", Name='" + this.name + '\'' +
                '}';
    }
}
