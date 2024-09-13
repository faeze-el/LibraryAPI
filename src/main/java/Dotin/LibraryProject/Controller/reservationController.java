package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.Book;
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
import java.util.Objects;

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

    @GetMapping("{id}")
    @Operation(summary = "return reservation requests by user_id given")
    public ResponseEntity< List<ReservationRequest>> getReservationsByUserId(@PathVariable Long id){
        List<ReservationRequest> res = service.getReservationsByUserId(id);
        return new ResponseEntity<>(res, !res.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }
//    @GetMapping("/requestsList/{userId}")
//    @Operation(summary = "return list of a user requests")
//    public String getRequestsByUserId(@PathVariable int userId){
//        List<ReservationRequest> reqs = libraryCore.getReservedRequestsByUserId(userId);
//        return "There are " + reqs.size() + " requests for you:\n" + reqs;
//    }
}
