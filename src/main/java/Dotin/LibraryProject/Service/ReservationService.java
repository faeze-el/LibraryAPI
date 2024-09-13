package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Repository.ReservationRepositoryNoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepositoryNoDB reservationRepository;

    public List<ReservationRequest> getReservationRequestList() {
        return reservationRepository.getAllReservations();
    }
    public void addNewReservation(ReservationRequest res) {reservationRepository.addReservation(res);}

}
