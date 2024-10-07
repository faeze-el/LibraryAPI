package dotin.library_project.repository;


import dotin.library_project.entity.User;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository {
    public List<User> getAllUsers();
    public void addUser(User user);
}