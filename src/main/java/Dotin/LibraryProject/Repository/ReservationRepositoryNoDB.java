package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.ReservationRequest;
import Dotin.LibraryProject.Entity.Enums.ReservationStatus;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.*;

@Repository
public class ReservationRepositoryNoDB implements ReservationRepository{
    private List<ReservationRequest> list = new ArrayList<>(Arrays.asList(
            new ReservationRequest(1L, 1L, 1L, randomDate(), randomDate(), ReservationStatus.PENDING_APPROVAL),
            new ReservationRequest(2L, 1L, 3L, randomDate(), randomDate(), ReservationStatus.PENDING_APPROVAL)
    ));

    public List<ReservationRequest> getAllReservations() {
        return list;
    }
    public List<ReservationRequest> getReservationsById(Long id){
        List<ReservationRequest> reservations = new ArrayList<>();
        for(ReservationRequest r : list){
            if(Objects.equals(r.getUserId(), id)) reservations.add(r);
        }
        return reservations;
    }
    public void addReservation(ReservationRequest reservation) {
        reservation.setRequestId((long) (list.size()+1));
        list.add(reservation);
    }

    @Override
    public boolean updateReservation(Long id, String isApprove) {
        isApprove = isApprove.toLowerCase();
        ReservationRequest request = null;
        for (ReservationRequest req : list){
            if (Objects.equals(req.getRequestId(), id))
                request = req;
        }
        if (request != null){
           if (isApprove.equals("approve")) {
               request.setReservationStatus(ReservationStatus.APPROVED);
           }
           else if (isApprove.equals("reject")) {
               request.setReservationStatus(ReservationStatus.REJECTED);
           }
           return true;
        }
        return false;
    }

    public static LocalDate randomDate() {
        final int maxAge = 100 * 12 * 31;
        return LocalDate.now().minusDays(new Random().nextInt(maxAge));
    }

}
