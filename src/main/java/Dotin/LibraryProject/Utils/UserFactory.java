package Dotin.LibraryProject.Utils;

import Dotin.LibraryProject.Entity.UserOld;
import Dotin.LibraryProject.Entity.Admin;
import Dotin.LibraryProject.Entity.Member;
import Dotin.LibraryProject.Entity.Librarian;


public class UserFactory {
    public static UserOld createUser(String type, String name) {
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
