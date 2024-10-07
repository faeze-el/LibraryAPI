package Dotin.LibraryProject.service;

import Dotin.LibraryProject.entity.User;
import Dotin.LibraryProject.repository.UserRepositoryByDb;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepositoryByDb userRepository;

    public UserService(UserRepositoryByDb userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.getAllUsers();
    }

    public void addNewUser(User user){
        userRepository.addUser(user);
    }
}
