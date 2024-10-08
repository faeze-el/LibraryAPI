package dotin.library_project.entity;

import dotin.library_project.entity.enums.ReservationStatus;
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

    @OneToOne(cascade = CascadeType.REMOVE)
    @JoinColumn(name = "book_id", nullable = false)
    private Book book;

    @ManyToOne(targetEntity = User.class, cascade = CascadeType.REMOVE)
    @JoinColumn(name = "user_id", nullable = false, referencedColumnName = "id")
    //@JsonBackReference()
    private User user;

    @Override
    public String toString() {
        return "Request{" +
                "requestId='" + requestId + '\'' +
                ", userId'" + this.user.id + '\'' +
                ", bookId='" + this.book.bookId + '\'' +
                ", issueDate=" + issueDate + '\'' +
                ", returnDate=" + returnDate + '\'' +
                ", isApproved=" + reservationStatus +
                '}';
    }
}
