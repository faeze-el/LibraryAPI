package Dotin.LibraryProject.Repository;

import Dotin.LibraryProject.Entity.ReservationRequest;

import java.util.List;

public interface ReservationRepository {
    public List<ReservationRequest> getAllReservations();
    public void addReservation(ReservationRequest reservation);
}
