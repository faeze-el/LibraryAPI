package Dotin.LibraryProject.repository;


import Dotin.LibraryProject.entity.User;

import java.util.List;

public interface UserRepository {
    public List<User> getAllUsers();
    public void addUser(User user);
}