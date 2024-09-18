package Dotin.LibraryProject.Entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    @Override
    public String toString() {
        return "User{" +
                ", ID='" + this.id + '\'' +
                ", Name='" + this.name + '\'' +
                '}';
    }
}
