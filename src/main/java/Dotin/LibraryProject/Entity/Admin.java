package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Utils.LibraryCore;

import java.util.ArrayList;
import java.util.List;

public class Admin extends User {
    public Admin(String name) {
        super(name);
    }
    @Override
    public List<String> getAvailableCommands() {
        List<String> actions = new ArrayList<String>();
        actions.add("add a book. The title of the book ");
        actions.add("remove book. Book ID");
        actions.add("View the list of books");
        return actions;
    }

    @Override
    public String executeCommand(int commandIndex, String args){
        LibraryCore libraryCore = LibraryCore.getInstance();
        switch (commandIndex) {
            case 1:
                System.out.println("adding book ..");
                return libraryCore.addBookCommand(args);
                //commandHandler.addBook(args);
            case 2:
                System.out.println("removing book ..");
                return libraryCore.removeBookCommand(args);
                //commandHandler.removeBook(args);
            case 3:
                return libraryCore.getBooksAsString();
            default:
                System.out.println("Invalid action.");
        }
        return "";
    }
}