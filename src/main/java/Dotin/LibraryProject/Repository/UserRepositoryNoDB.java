package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Enums.UserRole;
import Dotin.LibraryProject.Entity.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Repository
public class UserRepositoryNoDB implements UserRepository {
    private List<User> list = new ArrayList<>(Arrays.asList(
            new User(1L, "User1", "mina", "123456", UserRole.READER),
            new User(2L, "User2", "ali","123456", UserRole.READER),
            new User(3L, "User3","akbar", "123456", UserRole.ADMIN)
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