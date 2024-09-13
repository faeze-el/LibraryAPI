package Dotin.LibraryProject.Entity;

import lombok.*;


@AllArgsConstructor
@NoArgsConstructor
public @Data class Book {
    Long bookId;
    String title;
    BookStatus bookStatus;

    @Override
    public String toString() {
        return "Book{" +
                "Title='" + title + '\'' +
                ", ID='" + this.bookId + '\'' +
                ", isAvailable='" + this.bookStatus + '\'' +
                '}';
    }

}
