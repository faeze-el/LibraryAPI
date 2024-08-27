package Dotin.LibraryProject.Models;

public class Book {
    String title;
    int bookId;
    boolean isAvailable;
    public Book(){

    }
    public Book( int idbook, String title,boolean available){
        this.title = title;
        this.bookId = idbook;
        this.isAvailable = available;
    }
    public String getTitle(){
        return title;
    }
    public int getBookId(){
        return bookId;
    }
    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", ID='" + this.bookId + '\'' +
                ", isAvailable='" + this.isAvailable + '\'' +
                '}';
    }

}
