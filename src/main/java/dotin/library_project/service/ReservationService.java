package dotin.library_project.service;

import dotin.library_project.entity.enums.ReservationStatus;
import dotin.library_project.entity.ReservationRequest;
import dotin.library_project.repository.ReservationRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepository reservationRepository;

    public ReservationService(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    public List<ReservationRequest> getReservationRequestList() {
        return reservationRepository.getAllReservations();
    }
    public ReservationRequest getReservationsByUserId(Long id) {
        return reservationRepository.getReservationsById(id);
    }
    public void addNewReservation(ReservationRequest res) {
        reservationRepository.addReservation(res);
    }
    public boolean updateReservation(Long id, ReservationStatus status){
        return reservationRepository.updateReservation(id, status);}
}
