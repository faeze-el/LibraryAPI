package dotin.library_project.data.dto;

import dotin.library_project.data.enums.BookStatus;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class BookDto {

    @NotBlank(message = "The title is required and can not be empty")
    @Size(min=2, max=50, message = "The book title must be between 2 and 50 characters")
    private String title;

    private String bookStatus = BookStatus.BOOKABLE.toString();

}
