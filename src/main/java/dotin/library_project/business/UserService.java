package dotin.library_project.business;

import dotin.library_project.data.converter.UserConverter;
import dotin.library_project.data.entity.User;
import dotin.library_project.data.dto.UserDto;
import dotin.library_project.repository.UserRepository;
import dotin.library_project.web.ApiResponse;
import lombok.var;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;

    PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public UserService(@Qualifier("userRepositoryByDb") UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public ApiResponse<?> getUsers(){
        List<User> users = userRepository.getAllUsers();
        return new ApiResponse<>(true,users);
    }

    public ApiResponse<?> addNewUser(UserDto userdto){
        User user = UserConverter.convertToUser(userdto);
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.addUser(user);
        return new ApiResponse<>(true,"User added successfully");
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

    public User getUserFromSecurityContext(){
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails) {
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String username = userDetails.getUsername();
            Optional<User> user = userRepository.getUserByUserName(username);
            if (user.isPresent()) {
                return user.get();
            }
            else{
                throw new UsernameNotFoundException(username);
            }
        }
        return null;
    }
}
