package Dotin.LibraryProject.Controller;

import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class reservationController {

//    @Autowired
//    private ReservationService service;
//
//    @GetMapping
//    @Operation(summary = "return list of reservation requests")
//    public List<ReservationRequest> getRequestsList(){
//        return service.getReservationRequestList();
//    }
//    @PostMapping
//    @Operation(summary = "add new reservation request")
//    public ResponseEntity<String> addNewReservation(@RequestBody ReservationRequest req){
//        service.addNewReservation(req);
//        return new ResponseEntity<>("The request added successfully", HttpStatus.CREATED);
//    }
//
//    @GetMapping("{id}")
//    @Operation(summary = "return reservation requests by user_id given")
//    public ResponseEntity< List<ReservationRequest>> getReservationsByUserId(@PathVariable Long id){
//        List<ReservationRequest> res = service.getReservationsByUserId(id);
//        return new ResponseEntity<>(res, !res.isEmpty() ? HttpStatus.OK : HttpStatus.NOT_FOUND);
//    }
//
//    @PutMapping("{requestId}")
//    @Operation(summary = "reject or approve a request")
//    public ResponseEntity<String> updateReservationByRequestId(@PathVariable Long requestId, @RequestBody String isApprove){
//        boolean flag = service.updateReservation(requestId, isApprove);
//        return new ResponseEntity<>(flag ?"The request update successfully": "Can not find the request!!", flag ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
//    }
}
