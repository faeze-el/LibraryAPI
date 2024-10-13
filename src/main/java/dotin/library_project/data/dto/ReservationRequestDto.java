package dotin.library_project.data.dto;

import dotin.library_project.annotation.DateAfter;
import dotin.library_project.data.ReservationRequest;
import dotin.library_project.data.User;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@DateAfter(startDate = "issueDate", endDate = "returnDate", message = "End date must be after start date")
@Data
public class ReservationRequestDto {
    @Future
    @NotNull(message = "The issueDate is required.")
//    @NotEmpty(message = "The issueDate can not be empty.")
    private LocalDate issueDate;

    @Future(message = "The event date must be in the future")
    @NotNull(message = "The issueDate is required.")
//    @NotEmpty(message = "The issueDate can not be empty.")
    private LocalDate returnDate;

//    @NotEmpty
    private Long bookId;

    public ReservationRequest toReservationRequest(User user) {
        ReservationRequest r = new ReservationRequest();
        r.setIssueDate(issueDate);
        r.setReturnDate(returnDate);
        r.setBookId(bookId);
        r.setUser(user);
        return r;
    }
}
