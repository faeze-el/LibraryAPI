package Dotin.LibraryProject.entity;

import Dotin.LibraryProject.entity.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public @Data class ReservationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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
