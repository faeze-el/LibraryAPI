package dotin.library_project.data.dto;

import dotin.library_project.annotation.DateAfter;
import lombok.Data;
import org.checkerframework.checker.optional.qual.Present;

import javax.validation.constraints.*;
import java.util.Date;

@DateAfter(startDate = "issueDate", endDate = "returnDate", message = "End date must be after start date")
@Data
public class CalendarDto {
    @NotBlank(message = "The calendar event title is required and can not be empty")
    private String title;

    @FutureOrPresent(message = "The event date must be in the future")
    @NotNull(message = "The issueDate is required.")
    private Date startDate;

    @Future(message = "The event date must be in the future")
    @NotNull(message = "The returnDate is required.")
    private Date endDate;
}
