package dotin.library_project.entity;

import dotin.library_project.entity.enums.UserRole;
import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public @Data class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(nullable = false, unique = true)
    String username;
    String name;
    @Getter(AccessLevel.NONE)
    String password;
    @Enumerated(EnumType.STRING)
    UserRole role = UserRole.ROLE_READER;
    Boolean enabled = true;
    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", name='" + name + '\'' +
                ", userRole='" + role + '\'' +
                '}';
    }
}
