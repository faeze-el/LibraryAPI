package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Entity.Enums.BookStatus;
import lombok.*;

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

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", ID='" + this.bookId + '\'' +
                ", isAvailable='" + this.bookStatus + '\'' +
                '}';
    }

}
