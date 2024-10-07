package Dotin.LibraryProject.service;

import Dotin.LibraryProject.entity.User;
import Dotin.LibraryProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.getAllUsers();
    }

    public void addNewUser(User user){
        userRepository.addUser(user);
    }
}
