package Dotin.LibraryProject.service;

import Dotin.LibraryProject.entity.enums.ReservationStatus;
import Dotin.LibraryProject.entity.ReservationRequest;
import Dotin.LibraryProject.repository.ReservationRepositoryNoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    private final ReservationRepositoryNoDB reservationRepository;

    public ReservationService(ReservationRepositoryNoDB reservationRepository) {
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
