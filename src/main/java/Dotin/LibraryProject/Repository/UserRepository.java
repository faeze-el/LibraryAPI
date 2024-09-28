package Dotin.LibraryProject.Repository;


import Dotin.LibraryProject.Entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> getAllUsers();
    public void addUser(User user);
}