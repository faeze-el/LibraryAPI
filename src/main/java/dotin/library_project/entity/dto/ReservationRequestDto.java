package dotin.library_project.entity.dto;

import dotin.library_project.entity.Book;
import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.entity.User;
import dotin.library_project.entity.enums.BookStatus;
import lombok.Data;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.security.Principal;
import java.time.LocalDate;

@Data
public class ReservationRequestDto {
    @NotNull(message = "The issueDate is required.")
    @NotEmpty(message = "The issueDate can not be empty.")
    private LocalDate issueDate;
    @NotNull(message = "The issueDate is required.")
    @NotEmpty(message = "The issueDate can not be empty.")
    private LocalDate returnDate;
    private Long bookId;

    public ReservationRequest toReservationRequest() {
        ReservationRequest r = new ReservationRequest();
        r.setIssueDate(issueDate);
        r.setReturnDate(returnDate);
        r.setBookId(bookId);
        return r;
    }
}
