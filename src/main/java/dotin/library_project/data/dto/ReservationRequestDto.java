package dotin.library_project.data.dto;

import dotin.library_project.annotation.DateAfter;
import dotin.library_project.data.entity.ReservationRequest;
import dotin.library_project.data.entity.User;
import dotin.library_project.data.enums.ReservationStatus;
import lombok.Data;

import javax.validation.constraints.Future;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.util.Optional;

@DateAfter(startDate = "issueDate", endDate = "returnDate", message = "End date must be after start date")
@Data
public class ReservationRequestDto {
    @FutureOrPresent(message = "The event date must be in the future")
    @NotNull(message = "The issueDate is required.")
//    @NotBlank(message = "The issueDate is required and can not be empty.")
    private LocalDate issueDate;

    @Future(message = "The event date must be in the future")
    @NotNull(message = "The returnDate is required.")
//    @NotBlank(message = "The returnDate is required and can not be empty.")
    private LocalDate returnDate;

//    @NotEmpty
    private Long bookId;
    //private ReservationStatus status;

}
