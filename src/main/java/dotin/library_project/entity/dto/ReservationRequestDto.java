package dotin.library_project.entity.dto;

import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.entity.User;
import lombok.Data;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Data
public class ReservationRequestDto {
    @NotNull(message = "The issueDate is required.")
//    @NotEmpty(message = "The issueDate can not be empty.")
    private LocalDate issueDate;

    @NotNull(message = "The issueDate is required.")
//    @NotEmpty(message = "The issueDate can not be empty.")
    private LocalDate returnDate;

//    @NotEmpty
    private Long bookId;

    @Valid
    private User user;

    public ReservationRequest toReservationRequest() {
        ReservationRequest r = new ReservationRequest();
        r.setIssueDate(issueDate);
        r.setReturnDate(returnDate);
        r.setBookId(bookId);
        r.setUser(user);
        return r;
    }
}
