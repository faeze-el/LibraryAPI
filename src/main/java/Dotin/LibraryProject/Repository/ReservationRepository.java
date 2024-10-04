package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.Enums.ReservationStatus;
import Dotin.LibraryProject.Entity.ReservationRequest;

import java.util.List;

public interface ReservationRepository {
    public List<ReservationRequest> getAllReservations();
    public ReservationRequest getReservationsById(Long id);
    public void addReservation(ReservationRequest reservation);
    public boolean updateReservation(Long id, ReservationStatus status);
}
