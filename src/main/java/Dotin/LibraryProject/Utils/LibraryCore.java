package Dotin.LibraryProject.Utils;

import Dotin.LibraryProject.Models.Book;
import Dotin.LibraryProject.Models.ReservationRequest;
import Dotin.LibraryProject.Models.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.sql.Date;

public class LibraryCore {
    private static LibraryCore  instance;
    public static LibraryCore getInstance() {
        if (instance == null) instance = new LibraryCore();
        return instance;
    }

    private static List<Book> books;
    private static List<User> users;
    private static List<ReservationRequest> requests;

    public LibraryCore ()
    {
        books = new ArrayList<>();
        users = new ArrayList<>();
        requests = new ArrayList<>();
        populateBooks(); // to add books to the list
        populateUsers();
        populateRequests();
    }
    private void populateBooks() {
        books.add(new Book(0,"To Kill a Mockingbird", true));
        books.add(new Book(1, "1984", true));
        books.add(new Book(2, "The Great Gatsby", true));
        books.add(new Book(3, "Harry Potter and the Sorcerer's Stone", true));
    }
    private void populateUsers() {
        User user = UserFactory.createUser("admin", "Sara");
        users.add(user);
        user = UserFactory.createUser("member", "Ali");
        users.add(user);
        user = UserFactory.createUser("librarian", "Mina");
        users.add(user);
        user = UserFactory.createUser("member", "Ahmad");
        users.add(user);
    }
    private void populateRequests(){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            java.util.Date parsedDate = dateFormat.parse("2024-5-11");
            Date issueDate = new java.sql.Date(parsedDate.getTime());
            parsedDate = dateFormat.parse("2024-6-11");
            Date returnDate = new java.sql.Date(parsedDate.getTime());
            requests.add(new ReservationRequest(requests.size()+1, 1, 0, issueDate,returnDate ));
            requests.add(new ReservationRequest(requests.size()+1,3,2,issueDate,returnDate));
        }
        catch (ParseException e){

        }
    }
    public List<Book> getBooks()
    {
        return books;
    }
    public String getBooksAsString()
    {
        String result= "";
        for (Book book : books) {
            result += book.toString();
            result +=System.lineSeparator();
        }
        return result;
    }
    public String addBook(String name, boolean isAvailable){
        if(!name.isEmpty()) {
            int idb = books.size()+1;
            Book book = new Book(idb, name, true);
            books.add(book);
            return String.format("%s book was added with %d id",name, idb);
        }
        else return "Enter valid arguments";
    }
    public String getRequestsAsString()
    {
        String result= "";
        for (ReservationRequest request : requests) {
            result += request.toString();
            result +=System.lineSeparator();
        }
        return result;
    }
    public String getReservedRequestsByUserId(int userID){
        String result = "";
        for (ReservationRequest request : requests) {
            if (request.getUserId() == userID){
                result += request.toString();
                result +=System.lineSeparator();
            }
        }
        if(result.isEmpty()) result = String.format("Can not find request by your ID:%d",userID);
        return result;
    }
    public String reserveBookByTitle(String args, int userID){
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        java.sql.Date issueDate = null, returnDate;
        String searchString;
        if(!args.isEmpty()) {
            String[] argsArray = args.split(" ");
            searchString = argsArray[0];
            String issueDate_string = argsArray[1];
            try {
                java.util.Date parsedDate = dateFormat.parse(issueDate_string);
                issueDate = new java.sql.Date(parsedDate.getTime());
                String returnDate_string = argsArray[2];
                parsedDate = dateFormat.parse(returnDate_string);
                returnDate = new java.sql.Date(parsedDate.getTime());
            } catch (ParseException e) {
                return "Enter valid arguments";
            }
        }
        else return "Enter valid arguments";

        int foundBookId =-1;
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(searchString)) foundBookId=book.getBookId();
        }
        if(foundBookId==-1) return String.format("Sorry, can not find %s in our library",searchString);
        ReservationRequest rq = new ReservationRequest(requests.size()+1,userID, foundBookId,issueDate, returnDate );
        requests.add(rq);
        return String.format("Your request for reservation of %s book is registered.",searchString);
    }
    public String addBookCommand(String args){
        if(!args.isEmpty()) {
            String[] argsArray = args.split(" ");
            int idb = books.size()+1;
            String name = argsArray[0];
            Book book = new Book(idb, name, true);
            books.add(book);
            return String.format("%s book was added with %d id",name, idb);
        }
        else return "Enter valid arguments";
    }

    public String removeBook(String args){
        if(!args.isEmpty()) {
            books.remove(Integer.parseInt(args));
            return String.format("The book with ID %s was deleted.%n", args);
        }
        else return "Enter valid arguments";
    }
    public String approveRequest(String args) {
        if (!args.isEmpty()) {
            String[] argsArray = args.split(" ");
            int requestId = Integer.parseInt(argsArray[0]);
            String checkApprove = argsArray[1].toLowerCase();
            if (checkApprove.equals("approve") || checkApprove.equals("reject")) {
                requests.get(requestId-1).setIsApproved(checkApprove);
                return String.format("The request was %s with ID %d", checkApprove, requestId);
            } else return "Enter valid arguments";
        }
        else return "Enter valid arguments";
    }
    public User login(String name){
        User user = null;
        if(!name.isEmpty()) {
            for (User countUser : users) {
                if (countUser.getName().equals(name)) {
                    user = countUser;
                }
            }
            if (user == null) {
                user = UserFactory.createUser("member", name);
                users.add(user);
            }
        }
        return user;
    }

}
