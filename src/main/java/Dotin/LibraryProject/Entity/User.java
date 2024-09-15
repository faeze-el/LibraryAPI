package Dotin.LibraryProject.Entity;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
public @Data class User {
    Long id;
    String name;
    @Getter(AccessLevel.NONE)
    String password;
    @Override
    public String toString() {
        return "Book{" +
                ", ID='" + this.id + '\'' +
                ", Name='" + this.name + '\'' +
                '}';
    }
}
