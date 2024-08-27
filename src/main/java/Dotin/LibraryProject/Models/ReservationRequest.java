package Dotin.LibraryProject.Models;

import java.util.Date;

public class ReservationRequest {
    int requestId;
    int userId;
    int bookId;
    Date issueDate;
    Date returnDate;
    String isApproved;
    public ReservationRequest(int requestId, int userId, int bookId, Date issueDate, Date returnDate)
    {
        this.requestId = requestId;
        this.userId = userId;
        this.bookId = bookId;
        this.issueDate = issueDate;
        this.returnDate = returnDate;
        this.isApproved = "under review";
    }

    public int getUserId(){
        return userId;
    }
    public void setIsApproved(String s){isApproved = s;}
    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", userId'" + this.userId + '\'' +
                ", bookId='" + this.bookId + '\'' +
                ", issueDate=" + issueDate + '\'' +
                ", returnDate=" + returnDate + '\'' +
                ", isApproved=" + isApproved +
                '}';
    }
}
