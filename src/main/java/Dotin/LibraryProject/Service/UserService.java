package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.User;
import Dotin.LibraryProject.Repository.UserRepository;
import Dotin.LibraryProject.Utils.UserCreateDTO;
import Dotin.LibraryProject.Utils.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<UserDTO> getUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> userDTOS = new ArrayList<>();
        for (User user:users){
            userDTOS.add(toUserDTO(user));
        }
        return userDTOS;
    }

    public boolean addNewUser(UserCreateDTO userCreateDTO){
        if (userCreateDTO.getPassword().equals(userCreateDTO.getConfirmPassword())) {
            User user = toUser(userCreateDTO);
            userRepository.save(user);
            return true;
        }
        return false;
    }
    private UserDTO toUserDTO(User user){
        UserDTO userDTO = new UserDTO();
        userDTO.setId(user.getId());
        userDTO.setName(user.getName());
        userDTO.setUserRole(user.getRole());
        return userDTO;
    }
    private User toUser(UserCreateDTO userCreateDTO){
        User user = new User();
        user.setName(userCreateDTO.getName());
        user.setPassword(String.valueOf(userCreateDTO.getPassword().hashCode()));
        return user;
    }
}
