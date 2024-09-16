package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Utils.LibraryCore;

import java.util.ArrayList;
import java.util.List;

public class Librarian extends UserOld {
    public Librarian(String name) {
        super(name);
    }
    @Override
    public List<String> getAvailableCommands() {
        List<String> actions = new ArrayList<String>();
        actions.add("Approve or Reject a reserve. Request ID, approve or reject. for example : 4 approve");
        actions.add("View the list of requests");
        actions.add("View the list of books");
        return actions;
    }

    @Override
    public String executeCommand(int commandIndex, String args){
        LibraryCore libraryCore = LibraryCore.getInstance();
        switch (commandIndex) {
            case 1:
                if (!args.isEmpty()) {
                    String[] argsArray = args.split(" ");
                    int requestId = Integer.parseInt(argsArray[0]);
                    String checkApprove = argsArray[1].toLowerCase();
                    return libraryCore.approveRequest(requestId, checkApprove);
                }
                else return "Enter valid arguments";
            case 2:
                System.out.println("requests");
                return libraryCore.getRequestsAsString();
            case 3:
                System.out.println("books");
                return libraryCore.getBooksAsString();
            default:
                System.out.println("Invalid action.");
        }
        return "";
    }
}