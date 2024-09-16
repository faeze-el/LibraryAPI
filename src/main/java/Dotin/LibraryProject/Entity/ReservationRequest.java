package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Entity.Enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
public @Data class ReservationRequest {
    Long requestId;
    Long userId;
    Long bookId;
    LocalDate issueDate;
    LocalDate returnDate;
    ReservationStatus reservationStatus = ReservationStatus.PENDING_APPROVAL;

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", userId'" + this.userId + '\'' +
                ", bookId='" + this.bookId + '\'' +
                ", issueDate=" + issueDate + '\'' +
                ", returnDate=" + returnDate + '\'' +
                ", isApproved=" + reservationStatus +
                '}';
    }
}
