package Dotin.LibraryProject.Entity;

import java.util.List;

public abstract class UserOld {
    protected String name;
    protected int id;

    public UserOld(String name) {
        this.name = name;
    }
    public abstract List<String> getAvailableCommands();
    public abstract String executeCommand(int actionIndex,String args);
    public String getName() {return name;}
}
