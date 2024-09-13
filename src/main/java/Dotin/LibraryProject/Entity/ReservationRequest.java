package Dotin.LibraryProject.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
public @Data class ReservationRequest {
    Long requestId;
    Long userId;
    Long bookId;
    LocalDate issueDate;
    LocalDate returnDate;
    ReservationStatus isApproved = ReservationStatus.PENDING_APPROVAL;

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
