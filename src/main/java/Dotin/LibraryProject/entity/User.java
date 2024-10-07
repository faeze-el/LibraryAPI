package Dotin.LibraryProject.entity;

import Dotin.LibraryProject.entity.enums.UserRole;
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
    UserRole role = UserRole.READER;
    @Override
    public String toString() {
        return "User{" +
                ", ID='" + this.id + '\'' +
                ", Name='" + this.name + '\'' +
                '}';
    }
}
