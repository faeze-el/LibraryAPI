package dotin.library_project.service;

import dotin.library_project.entity.User;
import dotin.library_project.repository.UserRepository;
import lombok.var;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    public UserService(@Qualifier("userRepositoryByDb") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers(){
        return userRepository.getAllUsers();
    }

    public ResponseEntity<String> addNewUser(User user){
        userRepository.addUser(user);
        return new ResponseEntity<>("The User added successfully", HttpStatus.CREATED);
    }

    public User getUserByUserName(String userName) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByUserName(userName);
        if (user.isPresent()) {
            return user.get();
        }
        else{
            throw new UsernameNotFoundException(userName);
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.getUserByUserName(username);
        if (user.isPresent()) {
            var userObj = user.get();
            return  org.springframework.security.core.userdetails.User.builder()
                    .username(userObj.getUsername())
                    .password(userObj.getPassword())
                    .disabled(!userObj.getEnabled())
                    .authorities(userRepository.getGrantedAuthorities(userObj))
                    .build();
        }
        else{
            throw new UsernameNotFoundException(username);
        }
    }
}
