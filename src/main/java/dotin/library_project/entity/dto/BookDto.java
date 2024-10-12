package dotin.library_project.entity.dto;

import dotin.library_project.entity.Book;
import dotin.library_project.entity.enums.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    @NotNull(message = "The title is required.")
    @NotEmpty(message = "The title can not be empty.")
    @Size(min=2, max=50, message = "The book title must be between 2 and 50 characters")
    private String title;

    @NotNull(message = "Status cannot be null")
    private String bookStatus;

    public Book toBook() {
        Book b = new Book();
        b.setTitle(title);
        bookStatus = bookStatus.trim().toUpperCase();
        if(BookStatus.isValidEnum(bookStatus))
            b.setBookStatus(BookStatus.valueOf(bookStatus));
        else return null;
        return b;
    }
}
