package dotin.library_project.web;

import dotin.library_project.data.entity.User;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.enums.ReservationStatus;
import dotin.library_project.data.entity.ReservationRequest;
import dotin.library_project.business.ReservationService;
import dotin.library_project.business.UserService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Validated
@RestController
@RequestMapping("/reservations")
public class ReservationController {

    private final ReservationService service;
    private final UserService userService;

    public ReservationController(ReservationService service, UserService userService) {
        this.userService = userService;
        this.service = service;
    }

    @GetMapping
    @Operation(summary = "return list of reservation requests")
    public List<ReservationRequest> getRequestsList(){
        return service.getReservationRequestList();
    }

    @PostMapping
    @Operation(summary = "add new reservation request")
    public ResponseEntity<?> addNewReservation(@Valid @RequestBody ReservationRequestDto reqdto) {
        User user = userService.getUserFromSecurityContext();
        return service.addNewReservation(reqdto, user);
    }

    @GetMapping("{id}")
    @Operation(summary = "return reservation request by id given")
    public ResponseEntity< ?> getReservationsById(@Valid @PathVariable Long id){
        return service.getReservationsById(id);
    }

    @PutMapping("{requestId}")
    @Operation(summary = "reject or approve a request")
    public ResponseEntity<?> updateReservationByRequestId(@Valid @PathVariable Long requestId,@Valid @RequestParam("status") ReservationStatus status){
        return service.updateReservation(requestId, status);
    }
}
