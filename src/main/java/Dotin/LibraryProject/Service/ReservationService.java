package Dotin.LibraryProject.Service;

import Dotin.LibraryProject.Entity.Enums.ReservationStatus;
import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<ReservationRequest> getReservationRequestList() {
        return reservationRepository.getAllReservations();
    }
    public ReservationRequest getReservationsByUserId(Long id) {
        return reservationRepository.getReservationsById(id);
    }
    public void addNewReservation(ReservationRequest res) {
        reservationRepository.addReservation(res);
    }
    public boolean updateReservation(Long id, String isApprove){
        isApprove = isApprove.toLowerCase();
        ReservationRequest request = reservationRepository.getReservationsById(id);
        if (request != null) {
            if (isApprove.equals("approve")) {
                request.setReservationStatus(ReservationStatus.APPROVED);
                reservationRepository.addReservation(request);
                return true;
            } else if (isApprove.equals("reject")) {
                request.setReservationStatus(ReservationStatus.REJECTED);
                reservationRepository.addReservation(request);
                return true;
            }
        }
        return false;
    }
}
