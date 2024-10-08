package dotin.library_project.business.controller;

import dotin.library_project.entity.enums.ReservationStatus;
import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.service.ReservationService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;

    public ReservationController(ReservationService service) {
        this.service = service;
    }

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
    public ResponseEntity< ReservationRequest> getReservationsByUserId(@PathVariable Long id){
        ReservationRequest res = service.getReservationsByUserId(id);
        return new ResponseEntity<>(res, res==null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
    }

    @PutMapping("{requestId}")
    @Operation(summary = "reject or approve a request")
    public ResponseEntity<String> updateReservationByRequestId(@PathVariable Long requestId, @RequestParam("status") ReservationStatus status){
        boolean flag = service.updateReservation(requestId, status);
        return new ResponseEntity<>(flag ?"The request update successfully": "Can not find the request!!", flag ? HttpStatus.CREATED : HttpStatus.NOT_FOUND);
    }
}
