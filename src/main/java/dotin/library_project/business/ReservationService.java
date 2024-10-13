package dotin.library_project.business;

import dotin.library_project.data.User;
import dotin.library_project.data.dto.ReservationRequestDto;
import dotin.library_project.data.enums.ReservationStatus;
import dotin.library_project.data.ReservationRequest;
import dotin.library_project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(@Qualifier("reservationRepositoryByDb") ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationRequest> getReservationRequestList() {
        return reservationRepository.getAllReservations();
    }
    public ResponseEntity<?> getReservationsById(Long id) {
        if (id<=0) return new ResponseEntity<>("Enter a positive Id.",HttpStatus.BAD_REQUEST);
        ReservationRequest req = reservationRepository.getReservationsById(id);
        if(Objects.nonNull(req)) {
            return new ResponseEntity<>(req,HttpStatus.OK);
        }
        return new ResponseEntity<>("Reservation not found.",HttpStatus.NOT_FOUND);
    }
    public ResponseEntity<?> addNewReservation(ReservationRequestDto reqdto, User user) {
        try {
            Optional<ReservationRequest> request = Optional.ofNullable(reqdto.toReservationRequest(user));
            if(request.isPresent()) {
                reservationRepository.addReservation(request.get());
                new ResponseEntity<>("Reservation request added successfully", HttpStatus.CREATED);
            }
        }
        catch (Exception e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
        return new ResponseEntity<>("Not valid inputs", HttpStatus.BAD_REQUEST);
    }
    public ResponseEntity<?> updateReservation(Long id, ReservationStatus status){
        if (id<=0) return new ResponseEntity<>("Enter a positive Id.",HttpStatus.BAD_REQUEST);

        ReservationRequest req = reservationRepository.getReservationsById(id);
        if(Objects.nonNull(req)) {
            boolean flag = reservationRepository.updateReservation(id, status);
            return new ResponseEntity<>( flag ? HttpStatus.OK : HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<>("Can not find this id", HttpStatus.NOT_FOUND);
        }
}
