package dotin.library_project.web;

import dotin.library_project.business.BookService;
import dotin.library_project.business.CalendarService;
import dotin.library_project.data.dto.BookDto;
import dotin.library_project.data.dto.CalendarDto;
import dotin.library_project.data.entity.Book;
import dotin.library_project.data.entity.User;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.enums.ReservationStatus;
import dotin.library_project.data.entity.ReservationRequest;
import dotin.library_project.business.ReservationService;
import dotin.library_project.business.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.io.IOException;
import java.util.List;

import static dotin.library_project.data.converter.CalendarDtoConverter.toCalendarDto;

@Validated
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;
    private final UserService userService;
    private final CalendarService calendarService;
    private final BookService bookService;

    public ReservationController(ReservationService service, UserService userService , CalendarService calService, BookService bookService) {
        this.userService = userService;
        this.service = service;
        this.calendarService = calService;
        this.bookService = bookService;
    }

    @PostAuthorize("hasRole('ADMIN') or hasRole('LIBRARIAN')")
    @GetMapping
    @Operation(summary = "return list of reservation requests")
    public List<ReservationRequest> getRequestsList(){
        return service.getReservationRequestList();
    }

    @PreAuthorize("hasRole('READER')")
    @PostMapping
    @Operation(summary = "add new reservation request")
    public ResponseEntity<?> addNewReservation(@Valid @RequestBody ReservationRequestDto reqdto) throws IOException {
        User user = userService.getUserFromSecurityContext();
        ResponseEntity<?> res = bookService.getBookById(reqdto.getBookId());
        if (res.getStatusCode()== HttpStatus.OK){
        CalendarDto calendarDto = toCalendarDto(reqdto, (Book) res.getBody());
        calendarService.addEvent(calendarDto);
        return service.addNewReservation(reqdto, user);
        }
        return new ResponseEntity<>("", HttpStatus.NOT_FOUND);
    }

    @PreAuthorize("hasRole('READER')")
    @GetMapping("reservation")
    @Operation(summary = "return reservation request by id given")
    public ResponseEntity< ?> getReservationsUser() throws IOException {
        User user = userService.getUserFromSecurityContext();
        return service.getReservationsByUserId(user.getId());
    }

    @PreAuthorize("hasRole('LIBRARIAN')")
    @PutMapping("{requestId}")
    @Operation(summary = "reject or approve a request")
    public ResponseEntity<?> updateReservationByRequestId(@Valid @PathVariable Long requestId,@Valid @RequestParam("status") ReservationStatus status){
        return service.updateReservation(requestId, status);
    }
}