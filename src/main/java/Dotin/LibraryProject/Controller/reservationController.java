package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Utils.LibraryCore;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class reservationController {
//    LibraryCore libraryCore;
//    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
//    public reservationController(){
//        libraryCore = LibraryCore.getInstance();
//    }
//
//    @GetMapping("/requestsList")
//    @Operation(summary = "return list of requests")
//    public String getRequestsList(){
//        List<ReservationRequest> reqs = libraryCore.getRequests();
//        return "There are " + reqs.size() + " requests in this library:\n" + reqs;
//    }
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
