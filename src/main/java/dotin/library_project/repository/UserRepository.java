package dotin.library_project.repository;


import dotin.library_project.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthoritiesContainer;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository {
    public List<User> getAllUsers();
    public void addUser(User user);
    public Optional<User> getUserByUserName(String username);
    public List<GrantedAuthority> getGrantedAuthorities(User u);
}