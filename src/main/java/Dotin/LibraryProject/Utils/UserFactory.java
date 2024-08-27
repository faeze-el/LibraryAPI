package Dotin.LibraryProject.Utils;

import Dotin.LibraryProject.Models.User;
import Dotin.LibraryProject.Models.Admin;
import Dotin.LibraryProject.Models.Member;
import Dotin.LibraryProject.Models.Librarian;


public class UserFactory {
    public static User createUser(String type, String name) {
        switch (type.toLowerCase()) {
            case "member":
                return new Member(name);
            case "librarian":
                return new Librarian(name);
            case "admin":
                return new Admin(name);
            default:
                throw new IllegalArgumentException("Unknown user type.");
        }
    }
}
