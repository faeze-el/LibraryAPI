package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/reservations")
public class reservationController {

    @Autowired
    private ReservationService service;

    @GetMapping
    @Operation(summary = "return list of reservation requests")
    public List<ReservationRequest> getRequestsList(){
        return service.getReservationRequestList();
    }
    @PostMapping
    @Operation(summary = "add new reservation request")
    public ResponseEntity<String> addNewReservation(@RequestBody ReservationRequest req){
        service.addNewReservation(req);
        return new ResponseEntity<>("The request added successfully", HttpStatus.CREATED);
    }
//
//    @PostMapping("/addr")
//    @Operation(summary = "add new reservation request")
//    public String addNewRequest(@RequestParam String bookTitle, @RequestParam int userId , @DateTimeFormat(pattern = "yyyy-MM-dd")
//    final Date issueDate , @DateTimeFormat(pattern = "yyyy-MM-dd") final Date returnDate )  {
//        return libraryCore.reserveBookByTitle(bookTitle, userId, issueDate, returnDate );
//    }
//
//    @GetMapping("/requestsList/{userId}")
//    @Operation(summary = "return list of a user requests")
//    public String getRequestsByUserId(@PathVariable int userId){
//        List<ReservationRequest> reqs = libraryCore.getReservedRequestsByUserId(userId);
//        return "There are " + reqs.size() + " requests for you:\n" + reqs;
//    }
}
