package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Repository.ReservationRepositoryByDB;
import Dotin.LibraryProject.Repository.ReservationRepositoryNoDB;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepositoryNoDB reservationRepository;
    @Autowired
    private ReservationRepositoryByDB reservationRepositoryByDB;

    public List<ReservationRequest> getReservationRequestList() {
//        return reservationRepository.getAllReservations();
        return reservationRepositoryByDB.getAllReservations();
    }
    public List<ReservationRequest> getReservationsByUserId(Long id) {
//        return  reservationRepository.getReservationsById(id);
        return reservationRepositoryByDB.getReservationsById(id);
    }
    public void addNewReservation(ReservationRequest res) {
//        reservationRepository.addReservation(res);
        reservationRepositoryByDB.addReservation(res);
    }
    public boolean updateReservation(Long id, String isApprove){
//        return reservationRepository.updateReservation(id, isApprove);
        return reservationRepositoryByDB.updateReservation(id,isApprove);
    }
}
