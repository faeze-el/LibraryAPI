package dotin.library_project.data.dto;

import dotin.library_project.data.entity.Book;
import dotin.library_project.data.enums.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Optional;

@Data
public class BookDto {

    @NotBlank(message = "The title is required and can not be empty")
    @Size(min=2, max=50, message = "The book title must be between 2 and 50 characters")
    private String title;

    private String bookStatus = BookStatus.BOOKABLE.toString();

    public Optional<Book> toBook() {
        Book b = new Book();
        b.setTitle(title);
        bookStatus = bookStatus.trim().toUpperCase();
        if(BookStatus.isValidEnum(bookStatus))
            b.setBookStatus(BookStatus.valueOf(bookStatus));
        else return Optional.empty();
        return Optional.of(b);
    }
}
