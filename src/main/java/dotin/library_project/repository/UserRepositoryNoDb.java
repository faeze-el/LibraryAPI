package dotin.library_project.repository;

import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.entity.enums.UserRole;
import dotin.library_project.entity.User;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@Profile("dev")
@Repository
class UserRepositoryNoDb implements UserRepository {
    private List<User> list = new ArrayList<>(Arrays.asList(
            new User(1L, "User1", "mina", "123456", UserRole.ROLE_ADMIN, true, Collections.emptyList()),
            new User(2L, "User2", "ali","123456", UserRole.ROLE_LIBRARIAN,true, Collections.emptyList()),
            new User(3L, "User3","akbar", "123456", UserRole.ROLE_READER,true, Collections.emptyList())
    ));
    @Override
    public List<User> getAllUsers() {
        return list;
    }

    @Override
    public void addUser(User user) {
        user.setId((long) (list.size()+1));
        list.add(user);
    }
}