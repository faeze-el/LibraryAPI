package dotin.library_project.entity;

import dotin.library_project.entity.enums.BookStatus;
import lombok.*;
import javax.persistence.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@AllArgsConstructor
@NoArgsConstructor
@Entity
public @Data class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long bookId;
    String title;
    BookStatus bookStatus = BookStatus.BOOKABLE;

//    @OneToOne( fetch = FetchType.LAZY)
//    @JoinColumn(name = "req_id", referencedColumnName = "request_id", nullable = false)
//    private ReservationRequest reservationRequest;

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", ID='" + this.bookId + '\'' +
                ", isAvailable='" + this.bookStatus + '\'' +
                '}';
    }

}
