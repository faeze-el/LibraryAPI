package Dotin.LibraryProject.repository;

import Dotin.LibraryProject.entity.enums.ReservationStatus;
import Dotin.LibraryProject.entity.ReservationRequest;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReservationRepository {
    public List<ReservationRequest> getAllReservations();
    public ReservationRequest getReservationsById(Long id);
    public void addReservation(ReservationRequest reservation);
    public boolean updateReservation(Long id, ReservationStatus status);
}
