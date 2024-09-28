package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.User;
import Dotin.LibraryProject.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){
        return userRepository.getAllUsers();
    }

    public void addNewUser(User user){
        userRepository.addUser(user);
    }
}
