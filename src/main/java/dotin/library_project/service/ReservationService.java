package dotin.library_project.service;

import dotin.library_project.entity.enums.ReservationStatus;
import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(@Qualifier("reservationRepositoryByDb") ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationRequest> getReservationRequestList() {
        return reservationRepository.getAllReservations();
    }
    public ReservationRequest getReservationsByUserId(Long id) {
        return reservationRepository.getReservationsById(id);
    }
    public ResponseEntity<?> addNewReservation(ReservationRequest res) {

        reservationRepository.addReservation(res);
        return new ResponseEntity<>("Reservation request added successfully", HttpStatus.CREATED);
    }
    public boolean updateReservation(Long id, ReservationStatus status){
        return reservationRepository.updateReservation(id, status);}
}
