package dotin.library_project.data.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import dotin.library_project.data.enums.ReservationStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Entity
public @Data class ReservationRequest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long requestId;

//    @Column(nullable = false)
//    Long userId;

//    @Column(nullable = false)
//    Long bookId;

    @Column(nullable = false)
    LocalDate issueDate;

    @Column(nullable = false)
    LocalDate returnDate;

    @Column(nullable = false)
    ReservationStatus reservationStatus = ReservationStatus.PENDING_APPROVAL;

//    @OneToOne(mappedBy = "reservation_request", fetch = FetchType.LAZY)
//    private Book book;

    Long bookId;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE, fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    @JsonBackReference(value = "user-reservations")
    private User user;

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", userId'" + this.user.id + '\'' +
                ", bookId='" + this.bookId + '\'' +
                ", issueDate=" + issueDate + '\'' +
                ", returnDate=" + returnDate + '\'' +
                ", isApproved=" + reservationStatus +
                '}';
    }
}
