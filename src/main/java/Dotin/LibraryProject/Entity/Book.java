package Dotin.LibraryProject.Entity;

import Dotin.LibraryProject.Entity.Enums.BookStatus;
import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public @Data class Book {
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
