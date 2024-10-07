package dotin.library_project.repository;

import dotin.library_project.entity.enums.ReservationStatus;
import dotin.library_project.entity.ReservationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository {
    public List<ReservationRequest> getAllReservations();
    public ReservationRequest getReservationsById(Long id);
    public void addReservation(ReservationRequest reservation);
    public boolean updateReservation(Long id, ReservationStatus status);
}
