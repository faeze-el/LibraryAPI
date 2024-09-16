package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.ReservationRequest;

import java.util.List;

public interface ReservationRepository {
    public List<ReservationRequest> getAllReservations();
    public List<ReservationRequest> getReservationsById(Long id);
    public void addReservation(ReservationRequest reservation);
    public boolean updateReservation(Long id, String isApprove);
}
