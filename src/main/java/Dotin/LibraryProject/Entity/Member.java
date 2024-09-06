package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Utils.LibraryCore;

import java.util.ArrayList;
import java.util.List;

public class Member extends User {
    public Member(String name) {
        super(name);
    }
    @Override
    public List<String> getAvailableCommands() {
        List<String> actions = new ArrayList<String>();
        actions.add("Reserve a book. The arguments are Title, issueDate and returnDate. for example: Veronica 2024-01-12 2024-02-12");
        actions.add("View the list of books");
        actions.add("View reserved books status");
        return actions;
    }

    @Override
    public String executeCommand(int commandIndex, String args){
        LibraryCore libraryCore = LibraryCore.getInstance();
        switch (commandIndex) {
            case 1:
                return libraryCore.reserveBookByTitleCommand(args, this.id);
            case 2:
                return libraryCore.getBooksAsString();
            case 3:
                return libraryCore.getReservedRequestsByUserIdCommand(this.id);
            default:
                System.out.println("Invalid action.");
        }
        return "";
    }
}