package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.User;
import Dotin.LibraryProject.Repository.UserRepository;
import Dotin.LibraryProject.Repository.UserRepositoryByDb;
import Dotin.LibraryProject.Repository.UserRepositoryNoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepositoryNoDB userRepository;
    @Autowired
    private UserRepositoryByDb userRepositoryByDb;

    public List<User> getUsers(){
//        return userRepository.getAllUsers();
        return userRepositoryByDb.getAllUsers();
    }

    public void addNewUser(User user){
//        userRepository.addUser(user);
        userRepositoryByDb.addUser(user);
    }
}
