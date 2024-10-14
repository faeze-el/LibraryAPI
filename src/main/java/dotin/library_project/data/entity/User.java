package dotin.library_project.data.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import dotin.library_project.data.enums.UserRole;
import lombok.*;

import javax.persistence.*;
import java.util.List;

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
    @Column(nullable = false)
//    @Getter(AccessLevel.NONE)
    String password;
    @Enumerated(EnumType.STRING)
    UserRole role = UserRole.ROLE_READER;
    Boolean enabled = true;

    @OneToMany(targetEntity = ReservationRequest.class, mappedBy = "user")
    @JsonManagedReference(value = "user-reservations")
    private List<ReservationRequest> reservations;


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
